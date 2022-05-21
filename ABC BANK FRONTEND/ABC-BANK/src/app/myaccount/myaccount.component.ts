import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';
import { Account } from 'model/account';

@Component({
  selector: 'app-myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.css']
})
export class MyaccountComponent implements OnInit {

 public accNo:any=localStorage.getItem("customerAccNo");

  public acctype:any;
  public accbalance:any;
  public avgbalance=2468.4;
  constructor(private abcBankService:AbcBankService,private r:Router)

   { }

  ngOnInit(): void {
    this.getaccount();

  }
  public array:any=[];
  public getaccount()
  {
    this.abcBankService.getAccountDetailsById(this.accNo).subscribe(result=>
      {
        console.log(result);
        this.array=result
        this.acctype=this.array['accountType']
        this.accbalance=this.array['accountbalance']
        this.avgbalance=this.array['averagebalance']

      })
  }

  }


