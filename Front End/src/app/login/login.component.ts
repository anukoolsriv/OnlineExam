import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../Services/registration.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // url: string = "http://192.168.12.75:9090/user/fetch/";
  
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private  registrationService : RegistrationService,
            private router: Router){}
  ngOnInit() {
    this.loginForm=this.formBuilder.group( {
      email:['', Validators.required],
      password:[''],
 });

  }
  loginUser(){
    this.registrationService.login(this.loginForm.value)
    .subscribe(data => {
     alert('success')
     localStorage.setItem("username",this.loginForm.controls.email.value);
      this.router.navigate(['/userHome'])
  },
  error=>{
    alert('Invalid Login Credentials')
    localStorage.removeItem('username');
    this.router.navigate(['/login'])
  }

  );
  }

}
