import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ResponseClass } from '../Models/ResponseModel';
import { RegistrationService } from '../Services/registration.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  // url: string = "http://192.168.12.75:9090/user";

  registerForm: FormGroup;
  response : ResponseClass;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder,private  registrationService : RegistrationService,
            private router: Router){}
  
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['',Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")],
      mobile: ['',Validators.required],
      dateOfBirth: [''],
      state: [''],
      city: [''],
      qualification: [''],
      yearOfCompletion: ['']
    });
  }
  
  // registerModel = new userRegister("","", "",0,new Date(), "", "", "",0);

  addStudent() {
    this.submitted = true;
    if(this.registerForm.invalid){
      return;
    }

    // this.registrationService.register(this.registerForm.value)
    // .subscribe(data => this.response = {
    //   responseMessage : data['responseMessage'],
    //   responseCode : data['responseCode'],
    //   responseObject : data['responseObject']
    // });

    this.registrationService.register(this.registerForm.value)
    .subscribe(data => {
      alert('Registration Successful')
       this.router.navigate(['/login'])
   },
   error=>{
     alert('failed')
     this.router.navigate(['/'])
   }
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
