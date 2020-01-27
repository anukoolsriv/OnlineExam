import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { SelectSubjectComponent } from './select-subject/select-subject.component';


const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path: 'userRegistration', component: UserRegisterComponent},
  {path:'login', component:LoginComponent},
  {path:'resetPassword', component:ResetPasswordComponent},
  {path: 'forgotPassword', component:ForgotPasswordComponent},
  {path:'userHome',component:UserhomeComponent},
  {path:'selectExam',component:SelectSubjectComponent}
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
                                  SelectSubjectComponent  
                                  
                                  ]