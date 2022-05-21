import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AbcBankService } from './abc-bank.service';
import { CustomerServiceMenuComponent } from './customer-service-menu/customer-service-menu.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { ServiceRequestComponent } from './service-request/service-request.component';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';
import { StolenOrLostComponent } from './stolen-or-lost/stolen-or-lost.component';
import { QueryRequestComponent } from './query-request/query-request.component';
import { ViewRequestStatusComponent } from './view-request-status/view-request-status.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerServiceMenuComponent,
    MyProfileComponent,
    MyaccountComponent,
    AccountStatementComponent,
    ServiceRequestComponent,
    ChequebookRequestComponent,
    StolenOrLostComponent,
    QueryRequestComponent,
    ViewRequestStatusComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AbcBankService],
  bootstrap: [AppComponent]
})
export class AppModule { }
