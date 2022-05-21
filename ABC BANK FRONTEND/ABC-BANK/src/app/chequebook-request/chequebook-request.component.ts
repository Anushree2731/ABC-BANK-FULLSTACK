import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChequebookRequest } from 'model/chequebook-request';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-chequebook-request',
  templateUrl: './chequebook-request.component.html',
  styleUrls: ['./chequebook-request.component.css']
})
export class ChequebookRequestComponent implements OnInit {


public chequebookRequest:any;
public customerName:any;
public accNo:any;
public requestid=1;
public noofcheque:any;
public array:any=[];
public resDate:any=new Date().toISOString().slice(0, 10);


  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {
    this.customerName=localStorage.getItem("customerName")
    this.accNo=localStorage.getItem("customerAccNo");

  }

  public checkNoOfLeaves()
  {
    console.log(" "+this.noofcheque);

  }

public chequeBookDetails()
{
  this.chequebookRequest={

    "noofcheque":this.noofcheque,
    "requestdate":this.resDate,
    "responsestatus":"Pending",
    "account4":{
        "accountNumber":this.accNo
    },
    "servicerequest1":{
        "requestid":this.requestid
    }
    }
  this.abcBankService.chequeBookDetails(this.chequebookRequest).subscribe((result)=>{
console.log(result);
this.array=JSON.parse(JSON.stringify(result))
      if(this.array['Status']=='Success')
      {
        this.r.navigate(['makeservicerequest'])
      }else{

      }

    })




}
}
