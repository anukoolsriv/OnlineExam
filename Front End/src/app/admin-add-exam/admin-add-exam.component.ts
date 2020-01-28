import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RegistrationService } from '../Services/registration.service';
import { AdminServiceService } from '../Services/admin-service.service';

@Component({
  selector: 'app-admin-add-exam',
  templateUrl: './admin-add-exam.component.html',
  styleUrls: ['./admin-add-exam.component.css']
})
export class AdminAddExamComponent implements OnInit {

  selectedFile = null;

  constructor(private adminService : AdminServiceService) { }

  ngOnInit() {
  }

  onFileSelected(event){
    this.selectedFile = <File>event.target.files[0];
  }

  onUpload(){
    this.adminService.uploadFile(this.selectedFile)
      .subscribe(data =>{
        console.log(data)
      })
  }

}
