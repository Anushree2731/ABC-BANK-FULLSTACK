import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AbcBankService {
  public loggedIn:boolean = false;

  constructor(private http:HttpClient) { }

  public setUserStatus(response:boolean){
    this.loggedIn = true;
  }

  public validateCustomer(data:any){
    return(this.http.post("http://localhost:1303/UserLogin",data))
  }

  public getCustomerDetails(id:number)
  {
    return(this.http.get("http://localhost:1303/getcustomer/"+id))
  }

  public updateCustomerDetails(data:any)
  {
    return(this.http.put("http://localhost:1303/updatecustomer",data))
  }

  public getAccountDetailsById(id:number)
  {
    return(this.http.get("http://localhost:1303/getaccountnumber/"+id))
  }

  public getTransactionDetailsById(id:number)
  {
    return(this.http.get("http://localhost:1303/gettransactionbyAccno/"+id))
  }

  public chequeBookDetails(data:any)
  {
    console.log(data);

    return(this.http.post("http://localhost:1303/saveChequebook",data))
  }

  public StolenOrLostDetails(data:any)
  {
    return(this.http.post("http://localhost:1303/savestolenOrLost",data))
  }

  public QueryDetails(data:any)
  {console.log(data);

    return(this.http.post("http://localhost:1303/savequeryRequest",data))

  }

  public getchequeBookDetails(data:any)
  {
    console.log("data"+data);

    return(this.http.post("http://localhost:1303/getChequebookdetailsByreqidandaccno",data))
  }

  public getStolenOrLostDetails (data:any)
  {
    return(this.http.post("http://localhost:1303/getStolenOrLostdetailsByreqidandaccno",data))
  }

  public getQueryDetails (data:any)
  {
    return(this.http.post("http://localhost:1303/getQueryRequestdetailsByreqidandaccno",data))
  }
}
