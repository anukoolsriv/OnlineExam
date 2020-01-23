import { Component, OnInit } from '@angular/core';
import { userRegister } from '../user-register';
import { RegistrationService } from '../registration.service';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  url: string = "http://localhost:9090/students";

  registerForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private  registrationService : RegistrationService){}
  
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      email: [''],
      mobile: [''],
      dateOfBirth: [''] ,
      state: [''] ,
      city: [''] ,
      qualification: [''] ,
      yearOfCompletion: ['']
    });
  }
  
  // registerModel = new userRegister("","", "",0,new Date(), "", "", "",0);

  addStudent() {
    this.registrationService.register(this.registerForm.value)
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
}
