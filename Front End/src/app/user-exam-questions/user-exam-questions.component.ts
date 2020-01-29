import { Component, OnInit, Inject } from '@angular/core';
import { RegistrationService } from '../Services/registration.service';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { UserScoreModel } from '../Models/userScoreModel';

@Component({
  selector: 'app-user-exam-questions',
  templateUrl: './user-exam-questions.component.html',
  styleUrls: ['./user-exam-questions.component.css']
})
export class UserExamQuestionsComponent implements OnInit {

  public questions = []

  month = ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL","AUG", "SEP", "OCT", "NOV", "DEC"];
  score: number = 0;
  radioSelected: any;
  name : string =  "Hello! ";
  numberOfQuestions : number = 0;
  timeLeft: number = 60;
  interval: any;
  userscore : UserScoreModel;
  login : boolean = false;

  // answersSelected = { questionId ,optionSelected }

  constructor(private registrationService: RegistrationService,private router: Router) { }

  ngOnInit() {
    this.questions = JSON.parse(localStorage.getItem('examQuestions'))
    if(localStorage.getItem("username") == null){
      alert('Please login First')
      this.name += "Visitor";
      this.router.navigate(['/login'])
    }
    else{
      this.login = true;
      this.name += localStorage.getItem("username")
    }
    this.startTimer()

    
  }
  recordAnswer(questionId: string) {
    // console.log('hello')
    // console.log(questionId)
    // console.log(this.radioSelected);
    let value = document.getElementById(questionId) as HTMLSelectElement;
    console.log(value)
    value.style.display = "none"
    alert("Your response has been Recorded")
    this.numberOfQuestions++;


    this.registrationService.matchAnswers(questionId, this.radioSelected)
      .subscribe(data => {
        this.score += 1;
        console.log(this.score)
        // angular.element(document.getElementById('yourButtonId'))[0].disabled = true;
      },
        error => {
          console.log('wrong answer')
        })

      if(this.numberOfQuestions == 10){
        this.pauseTimer()
        alert('Thank you, Your responses have been submitted!')
        this.router.navigate(['/userHome'])
      }
  }
  startTimer() {
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        alert('Exam Completed! Thank You')
        this.pauseTimer()


        let date = new Date().getDate() + "-" + this.month[new Date().getMonth()] + "-" + new Date().getFullYear();

        let obj = {
          "userEmail": localStorage.getItem("username"),
          "examName" : localStorage.getItem("examName"),
          "score" : this.score,
          "dateOfExam" : date,
          "timeTaken" : 60-this.timeLeft
        }

        this.registrationService.setUserScore(obj)
          .subscribe(data => {
          })


        this.router.navigate(['/userHome'])
      }
    }, 1000)
  }
  pauseTimer() {
    clearInterval(this.interval);
  }
  onLogOut (){
    localStorage.removeItem("username");
    alert("Thank You For Your Time, Logging You Out...")
    this.login = false;
    this.router.navigate(['/login'])
}


}
