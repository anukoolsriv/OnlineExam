import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  login : boolean = false;
  name : string =  "Hello! ";

  constructor(private router : Router) { }

  ngOnInit() {
    if(localStorage.getItem("username") == null){
      alert('Please login First')
      this.name += "Visitor";
      this.router.navigate(['/login'])
    }
    else{
      this.login = true;
      this.name += localStorage.getItem("username")
    }
  }
  onLogOut (){
      localStorage.removeItem("username");
      alert("Thank You For Your Time, Logging You Out...")
      this.login = false;
      this.router.navigate(['/login'])
  }

}
