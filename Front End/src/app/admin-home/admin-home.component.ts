import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  addQuestionFlag : boolean = false;
  removeQuestionFlag : boolean = false;
  viewReportFlag : boolean = false;
  // value : string;
  // name : string;


  constructor() { }

  ngOnInit() {
  }

  displayPage(event) {
    var target = event.target || event.srcElement || event.currentTarget;
    var idAttr = target.attributes.id;
    var value = idAttr.nodeValue;

    console.log(value)
    // console.log(this.name)
    if(value == 'AddQuestions'){
      this.addQuestionFlag = true;
      this.removeQuestionFlag = false;
      this.viewReportFlag = false;
    }
    else if(value == 'RemoveQuestions'){
      this.addQuestionFlag = false;
      this.removeQuestionFlag = true;
      this.viewReportFlag = false;
    }
    else if(value == 'ViewReport'){
      this.addQuestionFlag = false;
      this.removeQuestionFlag = false;
      this.viewReportFlag = true;
    }
  }

}
