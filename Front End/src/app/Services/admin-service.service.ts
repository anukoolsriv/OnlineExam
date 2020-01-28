import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  url: string ='http://192.168.12.75:9090/user'
  constructor(private http: HttpClient) { }

  // upload file
  uploadFile(file: File) {
    console.log(file)
    const fd = new FormData();
    fd.append('question', file,file.name);
    let tempUrl = this.url + "/uploadFile";
    console.log(file)
    return this.http.post<any>(tempUrl,fd,{responseType:'json'})
  }
}
