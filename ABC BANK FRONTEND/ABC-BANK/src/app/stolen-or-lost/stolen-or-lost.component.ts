import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-stolen-or-lost',
  templateUrl: './stolen-or-lost.component.html',
  styleUrls: ['./stolen-or-lost.component.css'],
})
export class StolenOrLostComponent implements OnInit {
  public StolenOrLost: any;
  public customerName: any;
  public accNo: any;
  public requestid = 2;
  public stolenOrLostOn: any;
  public array: any = [];
  public resDate:any=new Date().toISOString().slice(0, 10);
  constructor(private abcBankService: AbcBankService, private r: Router) {}

  ngOnInit(): void {
    this.customerName = localStorage.getItem('customerName');
    this.accNo = localStorage.getItem('customerAccNo');
  }


  public StolenOrLostDetails() {
    this.StolenOrLost = {
      stolen_Date: this.stolenOrLostOn,
      response_Status: 'Pending',
      request_Date: this.resDate,
      servicerequest: {
        requestid: 2,
      },
      account3: {
        accountNumber: this.accNo,
      },
    };
    this.abcBankService
      .StolenOrLostDetails(this.StolenOrLost)
      .subscribe((result) => {
        console.log(result);
        this.array = JSON.parse(JSON.stringify(result));
        if (this.array['Status'] == 'Success') {
          this.r.navigate(['makeservicerequest']);
        } else {
        }
      });
  }
}
