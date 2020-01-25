import { Component, OnInit } from '@angular/core';
import  {UserLogin} from '../Models/user-login';
import{LoginService} from '../Services/login.service';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  url: string = "http://localhost:9090/user/fetch/";
  
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private  LoginService : LoginService,
            private router: Router){}
  ngOnInit() {
    this.loginForm=this.formBuilder.group( {
      email:['anukoolsriv@gmail.com'],
      password:['']
 });

  }
  loginUser(){
    this.LoginService.login(this.loginForm.value)
    .subscribe(data => {
     alert('success')
      this.router.navigate(['/userHome'])
  },
  error=>{
    alert('failed')
    this.router.navigate(['/'])
  }

  );
  }

}
