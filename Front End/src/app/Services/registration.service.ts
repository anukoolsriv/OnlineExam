import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { UserRegister } from '../Models/user-register';
// import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {


  url: string ='http://localhost:9090/user/';
  constructor(private http: HttpClient) { }

  //register user
  register(user : UserRegister){
    // console.log(this._http.get<any>(this._url));
    return this.http.post<any>(this.url, user,{responseType: 'json'}); 
  }
}
