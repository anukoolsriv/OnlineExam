import { Component, OnInit } from '@angular/core';
import { userRegister } from '../user-register';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  constructor(private  registrationService : RegistrationService){}
  
  
  ngOnInit(): void {
    
  }
  
  registerModel = new userRegister("","", "",0,new Date(), "", "", "",0);

  onSubmit() {
    this.registrationService.register(this.registerModel)
    .subscribe(
      data => console.log('Success!', data),
      error => console.error('Error!', error)
    );
  }

  populateCity(): void {
    // console.log("123");
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "assets/json/state-city.json", true);
    xhr.responseType = "text";
    xhr.send();

    xhr.onload = function () {
      // console.log(xhr.status);
      if (xhr.status === 200) {
        var data = JSON.parse(xhr.responseText);
        var cityHtml = "";
        var state = (<HTMLInputElement>document.getElementById("state")).value;
        var i = 0;
        while (i < data[state].length) {
          cityHtml += "<option value=" + data[state][i++] + ">" + data[state][i++] + "</option>";
        }
        document.getElementById("city").innerHTML = cityHtml;
      }
    }
  }
  // getYears(): void{
  //   let year="";
  //   let start=1970;
  //   let end = Number(new Date().getFullYear);
  //   let i = start;

  //   while(i <= end){
  //     year+= "<option value="+i+">" + i + "</option>";
  //   }
  //   document.getElementById("yearofcompletion").innerHTML = year;
  // }
}
