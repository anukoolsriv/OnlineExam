import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserRegisterComponent } from './user-register/user-register.component';


const routes: Routes = [
  {path: 'userRegistration', component: UserRegisterComponent},
  {path:'login', component:LoginComponent},
  {path:'resetPassword', component:ResetPasswordComponent},
  {path: 'forgotPassword', component:ForgotPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [UserRegisterComponent, LoginComponent, ResetPasswordComponent, ForgotPasswordComponent]