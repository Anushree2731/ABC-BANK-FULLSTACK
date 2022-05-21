import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-query-request',
  templateUrl: './query-request.component.html',
  styleUrls: ['./query-request.component.css']
})
export class QueryRequestComponent implements OnInit {

  public QueryRequest:any;
  public customerName:any;
  public accNo: any;
  public requestid = 3;
  public array: any = [];
  public userquery:any;
  public resDate:any=new Date().toISOString().slice(0, 10);

  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {
    this.customerName = localStorage.getItem('customerName');
    console.log(this.accNo);

  }
  public QueryRequestDetails() {
    this.QueryRequest = {
      "userquery":this.userquery,
    "querydate":this.resDate,
    "responsestatus":"pending",
    "account5":{
        "accountNumber":localStorage.getItem("customerAccNo")
    },
    "servicerequest2":{
        "requestid":this.requestid
    }
  };

  this.abcBankService
      .QueryDetails(this.QueryRequest)
      .subscribe((result) => {
        console.log(result);
        this.array = JSON.parse(JSON.stringify(result));
        if (this.array['Status'] == 'Success') {
          this.r.navigate(['menu']);
        } else {
        }
      });
}
}
