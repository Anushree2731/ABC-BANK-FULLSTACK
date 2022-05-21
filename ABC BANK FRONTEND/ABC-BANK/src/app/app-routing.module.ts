import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { AuthGuard } from './auth.guard';
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';
import { CustomerServiceMenuComponent } from './customer-service-menu/customer-service-menu.component';
import { LoginComponent } from './login/login.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { QueryRequestComponent } from './query-request/query-request.component';
import { ServiceRequestComponent } from './service-request/service-request.component';
import { StolenOrLostComponent } from './stolen-or-lost/stolen-or-lost.component';
import { ViewRequestStatusComponent } from './view-request-status/view-request-status.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'menu',
    canActivate: [AuthGuard],
    component: CustomerServiceMenuComponent,
  },
  { path: 'profile', canActivate: [AuthGuard], component: MyProfileComponent },
  { path: 'account', canActivate: [AuthGuard], component: MyaccountComponent },
  {
    path: 'accountstatement',
    canActivate: [AuthGuard],
    component: AccountStatementComponent,
  },
  {
    path: 'makeservicerequest',
    canActivate: [AuthGuard],
    component: ServiceRequestComponent,
  },
  {
    path: 'chequebookrequest',
    canActivate: [AuthGuard],
    component: ChequebookRequestComponent,
  },
  {
    path: 'StolenOrLost',
    canActivate: [AuthGuard],
    component: StolenOrLostComponent,
  },
  {
    path: 'queryRequest',
    canActivate: [AuthGuard],
    component: QueryRequestComponent,
  },
  {
    path: 'viewRequestStatus',
    canActivate: [AuthGuard],
    component: ViewRequestStatusComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
