import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
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
      email:['anukoolsriv@gmail.com'],
      password:['']
 });

  }
  loginUser(){
    this.registrationService.login(this.loginForm.value)
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
