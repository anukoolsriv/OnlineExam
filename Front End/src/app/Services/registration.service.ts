import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { UserRegisterModel } from '../Models/UserRegisterModel';
import { UserLogin } from '../Models/UserLoginModel';
import { ExamModel } from '../Models/examModel';
import { Observable } from 'rxjs';
import { QuestionModel } from '../Models/QuestionModel';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  url: string ='http://192.168.43.15:9090/user'
  // url: string ='http://192.168.12.75:9090/user';
  // public exams = [];


  constructor(private http: HttpClient) { }

  //register user
  register(user : UserRegisterModel){
    // console.log(this._http.get<any>(this._url));
    return this.http.post<any>(this.url+"/register", user,{responseType: 'json'}); 
  }
  //validate login
  login(login:UserLogin){
    return this.http.post<any>(this.url+"/login",login,{responseType: 'json'});
  }

  //fetch all Exams
  fetchExams() : Observable<ExamModel[]>{
    return this.http.get<ExamModel[]>(this.url+"/fetchExams",{responseType:'json'})
  }
  
  // get questions based on exam
  getQuestions(exam: string) : Observable<QuestionModel[]> {
    let tempUrl = this.url + "/getQuestions/" + exam;
    return this.http.get<QuestionModel[]>(tempUrl,{responseType:'json'})
  }

  // match answers for the question
  matchAnswers(questionId: number, radioSelected: any) {
    let tempUrl = this.url + "/matchAnswers/" + questionId + "/" + radioSelected;
    return this.http.get<any>(tempUrl,{responseType:'json'})
  }
}
