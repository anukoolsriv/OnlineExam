import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../Services/registration.service';

@Component({
  selector: 'app-user-exam-questions',
  templateUrl: './user-exam-questions.component.html',
  styleUrls: ['./user-exam-questions.component.css']
})
export class UserExamQuestionsComponent implements OnInit {
  
  public questions = []

  counter : number = 0;
  radioSelected: any;

  // answersSelected = { questionId ,optionSelected }

  constructor(private  registrationService: RegistrationService) { }

  ngOnInit() {
    this.questions = JSON.parse(localStorage.getItem('examQuestions'))
  }
  recordAnswer(questionId : number){
    // console.log('hello')
    // console.log(questionId)
    // console.log(this.radioSelected);

    this.registrationService.matchAnswers(questionId,this.radioSelected)
    .subscribe(data =>{
      this.counter += 1;
      console.log(this.counter)
    },
      error=> {

      })

  }

}
