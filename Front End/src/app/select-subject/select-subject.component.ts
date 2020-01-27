import { Component, OnInit } from '@angular/core';
import { ExamModel } from '../Models/examModel';
import { RegistrationService } from '../Services/registration.service';

@Component({
  selector: 'app-select-subject',
  templateUrl: './select-subject.component.html',
  styleUrls: ['./select-subject.component.css']
})
export class SelectSubjectComponent implements OnInit {

  public exams = [];

  constructor(private registrationService : RegistrationService) { }

  ngOnInit() {
    this.registrationService.fetchExams().subscribe( data =>
      this.exams = data
    );

  }
  getQuestions(exam : string) : any{
    alert(exam)
    this.registrationService.getQuestions(exam).subscribe(data =>
      this.exams = data
      );

  }

}
