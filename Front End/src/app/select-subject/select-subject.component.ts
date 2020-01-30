import { Component, OnInit } from '@angular/core';
import { ExamModel } from '../Models/examModel';
import { RegistrationService } from '../Services/registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-subject',
  templateUrl: './select-subject.component.html',
  styleUrls: ['./select-subject.component.css']
})
export class SelectSubjectComponent implements OnInit {

  public exams = [];
  name : string =  "Hello! ";
  flag: boolean = false;
  constructor(private registrationService: RegistrationService, private router: Router) { }

  ngOnInit() {

    if (localStorage.getItem("username") == null) {
      alert('Please login First')
      this.name += "Visitor";
      this.router.navigate(['/login'])
    }
    else {
      this.registrationService.fetchExams().subscribe(data =>{
        this.exams = data
      });
      this.name += localStorage.getItem("username")
    }

  }
  getQuestions(exam: string): any {

    // alert(exam)
    localStorage.setItem('examName', exam)
    this.registrationService.getQuestions(exam).subscribe(data => {
      this.flag = true
      this.exams = data
      // alert(this.exams)
      localStorage.setItem('examQuestions', JSON.stringify(this.exams))
      // alert(JSON.parse(localStorage.getItem('examQuestions')))
      this.router.navigate(['/userExamQuestions'])

    },
      error => {
        alert('error')
        this.flag = false
      });

  }
  onLogOut(){
    localStorage.removeItem("username");
    alert("Thank You For Your Time, Logging You Out...")
    this.router.navigate(['/login'])
  }
}
