import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { userRegister } from './user-register';
// import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {


  url: string ='http://localhost:9090/registerUser/';
  constructor(private http: HttpClient) { }

  //register user
  register(user : userRegister){
    // console.log(this._http.get<any>(this._url));
    return this.http.post<any>(this.url, user,{responseType: 'json'}); 
  }
}
