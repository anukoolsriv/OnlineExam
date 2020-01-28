import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { SelectSubjectComponent } from './select-subject/select-subject.component';
import { UserExamQuestionsComponent } from './user-exam-questions/user-exam-questions.component';
import { QuizComponent } from './quiz/quiz.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminAddExamComponent } from './admin-add-exam/admin-add-exam.component';


const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path: 'userRegistration', component: UserRegisterComponent},
  {path:'login', component:LoginComponent},
  {path:'resetPassword', component:ResetPasswordComponent},
  {path: 'forgotPassword', component:ForgotPasswordComponent},
  {path:'userHome',component:UserhomeComponent},
  {path:'selectExam',component:SelectSubjectComponent},
  {path:'userExamQuestions', component:UserExamQuestionsComponent},
  {path:'Quiz',component:QuizComponent},
  {path:'AdminHome',component:AdminHomeComponent},
  {path:'AdminAddExam',component:AdminAddExamComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent,
                                  UserRegisterComponent,
                                  LoginComponent,
                                  ResetPasswordComponent,
                                  ForgotPasswordComponent,
                                  UserhomeComponent,
                                  SelectSubjectComponent,
                                  UserExamQuestionsComponent,
                                  QuizComponent,
                                  AdminHomeComponent,
                                  AdminAddExamComponent                    
                                  ]