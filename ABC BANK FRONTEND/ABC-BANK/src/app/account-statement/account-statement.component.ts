import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {
  public accNo:any=localStorage.getItem("customerAccNo");
  public date:any;
  public description:any;
  public creditordebit:any;
  public closingbalance=8768.0;

  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {
  this.gettransaction()
  }
  public array:any=[];
    public gettransaction()
    {
      this.abcBankService.getTransactionDetailsById(this.accNo).subscribe(result =>{
      console.log(result);
        this.array=result
        this.date=this.array['transcationDate']
        this.description=this.array['description']
        this.creditordebit=this.array['creditordebit']
        this.closingbalance=this.array['closingBalance']



      })

    }
}
