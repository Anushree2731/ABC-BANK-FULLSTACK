import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Credentials } from 'model/credentials';
import Swal from 'sweetalert2';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public credentials = new Credentials()
  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {

  }
  public array:any=[];

  public validateUser():void{
    this.abcBankService.validateCustomer(this.credentials).subscribe((result)=>{
      this.array =JSON.parse(JSON.stringify(result));
      console.log(result);

      if(this.array['status']=="success")
      {
        localStorage.setItem("customerName",this.array['customerName'])
        localStorage.setItem("customerId",this.array['customerId'])
        localStorage.setItem("customerAccNo",this.array['accountNo'])
        this.abcBankService.setUserStatus(true);
        this.r.navigate(['menu']);
      }else
      {
        Swal.fire({
          title:'username/password are wrong',
          confirmButtonColor:'#D8CE17',
          icon:'error'
        })
        console.log(result);

      }


    })
  }

}
