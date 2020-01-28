import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { UserLogin } from '../Models/user-login';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

url: string ='http://192.168.43.15:9090/user/fetch/';
  constructor(private http: HttpClient) { }
  //login user
  login(login:UserLogin){
    return this.http.post<any>(this.url,login,{responseType: 'json'});
  }
}
