import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule, routingComponents} from './app-routing.module';
import { AppComponent } from './app.component';;
import { RegistrationService } from './Services/registration.service';
import { UserOptionsComponent } from './user-options/user-options.component';
import { UserExamQuestionsComponent } from './user-exam-questions/user-exam-questions.component';
import { AdminAddExamComponent } from './admin-add-exam/admin-add-exam.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminRemoveExamComponent } from './admin-remove-exam/admin-remove-exam.component';
import { AdminViewReportComponent } from './admin-view-report/admin-view-report.component';
import { AdminServiceService } from './Services/admin-service.service';
import { UserViewReportComponent } from './user-view-report/user-view-report.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    UserOptionsComponent,
    UserExamQuestionsComponent,
    AdminAddExamComponent,
    AdminHomeComponent,
    AdminRemoveExamComponent,
    AdminViewReportComponent,
    UserViewReportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [RegistrationService,AdminServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
