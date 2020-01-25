import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule, routingComponents} from './app-routing.module';
import { AppComponent } from './app.component';;
import { RegistrationService } from './Services/registration.service';
import { LoginService } from './Services/login.service';
import { UserOptionsComponent } from './user-options/user-options.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    UserOptionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [RegistrationService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
