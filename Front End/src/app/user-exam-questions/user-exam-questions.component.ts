import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-exam-questions',
  templateUrl: './user-exam-questions.component.html',
  styleUrls: ['./user-exam-questions.component.css']
})
export class UserExamQuestionsComponent implements OnInit {
  
  public questions = []

  constructor() { }

  ngOnInit() {
    this.questions = JSON.parse(localStorage.getItem('examQuestions'))
  }

}
