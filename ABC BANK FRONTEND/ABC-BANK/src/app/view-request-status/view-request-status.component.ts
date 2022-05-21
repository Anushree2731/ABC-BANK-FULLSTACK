import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-view-request-status',
  templateUrl: './view-request-status.component.html',
  styleUrls: ['./view-request-status.component.css']
})
export class ViewRequestStatusComponent implements OnInit {

  public requestval:any;
  public servicerequest:any
  public accNo:number=0;
  public array:any=[];

  public customerName:any;

  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {
    this.customerName = localStorage.getItem('customerName');
    this.accNo=JSON.parse(localStorage.getItem('customerAccNo')!)
}
  public onSearch()
  {
    console.log("Working:"+this.requestval)
    if(this.requestval==1)
    {
      this.servicerequest={
          "accountNumber":this.accNo,
          "requestid":parseInt(this.requestval)
      }
      console.log(this.servicerequest);
      this.abcBankService.getchequeBookDetails(this.servicerequest).subscribe((result)=>
      {
        console.log(result);
        this.array=result

      })

    }else if(this.requestval==2)
    {
      this.servicerequest={
      "accountNumber":this.accNo,
      "requestid":parseInt(this.requestval)
      }
      console.log(this.servicerequest);
      this.abcBankService.getStolenOrLostDetails(this.servicerequest).subscribe((result)=>
      {
        console.log(result);
        this.array=result

      })
    }
    else if(this.requestval==3)
    {
      this.servicerequest={
          "accountNumber":this.accNo,
          "requestid":parseInt(this.requestval)
      }
      console.log(this.servicerequest);
      this.abcBankService.getQueryDetails(this.servicerequest).subscribe((result)=>
      {
        console.log(result);
        this.array=result

      })
    }
  }

  public fetchdetails(tid:number,id:number)
  {
    if(id==1)
    {
      console.log("chequebook:"+tid);
      localStorage.removeItem("chequebookrequest_Id")
      localStorage.setItem("chequebookrequest_Id",tid.toString())
      localStorage.removeItem("requestid")
      localStorage.setItem("requestid",id.toString())
      this.r.navigate(['chequebookrequest'])
    }
    else if(id==2)
    {
      console.log("StolenOrLost:"+tid);
      localStorage.removeItem("stolenrequest_Id")
      localStorage.setItem("stolenrequest_Id",tid.toString())
      localStorage.removeItem("requestid")
      localStorage.setItem("requestid",id.toString())
      this.r.navigate(['StolenOrLost'])
    }else if (id==3)
    {
      console.log("query:"+tid);
      localStorage.removeItem("queryrequestid")
      localStorage.setItem("queryrequestid",tid.toString())
      localStorage.removeItem("requestid")
      localStorage.setItem("requestid",id.toString())
      this.r.navigate(['queryRequest'])

    }

    }

  }


