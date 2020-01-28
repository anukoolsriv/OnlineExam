import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class QuizService {

  constructor(private http: HttpClient) { }

  get(url: string) {
    return this.http.get(url);
  }

  getQuestions() {
    // console.log(JSON.parse(localStorage.getItem('examQuestions')))
    let questions = JSON.parse(localStorage.getItem('examQuestions'));
    console.log(questions.responseObject)

    return questions.responseObject;
    // [
    //   { id: '/questions.responseObject', name: 'JavaScript' },
    //   { id: '/assets/json/aspnet.json', name: 'Asp.Net' },
    //   { id: '/assets/json/csharp.json', name: 'C Sharp' },
    //   { id: '/assets/json/designPatterns.json', name: 'Design Patterns' }
    // ];
  }

}
