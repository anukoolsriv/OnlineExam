import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { userRegister } from './user-register';
// import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {


  _url='http://localhost:9090/registerUser/';
  constructor(private _http: HttpClient) { }

  register(user : userRegister){
    // console.log(this._http.get<any>(this._url));
    return this._http.post<any>(this._url, user); 
  }
}
