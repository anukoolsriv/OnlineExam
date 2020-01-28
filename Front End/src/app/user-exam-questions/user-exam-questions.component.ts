import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-exam-questions',
  templateUrl: './user-exam-questions.component.html',
  styleUrls: ['./user-exam-questions.component.css']
})
export class UserExamQuestionsComponent implements OnInit {
  
  public questions = []

  radioSelected: any;

  constructor() { }

  ngOnInit() {
    this.questions = JSON.parse(localStorage.getItem('examQuestions'))
  }
  recordAnswer(questionId : number){
    // console.log('hello')
    console.log(questionId)
    console.log(this.radioSelected);

    

  }

}
