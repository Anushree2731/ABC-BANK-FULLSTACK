import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'model/customer';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  public customer = new Customer()
  customerName: any;
  customerId:any;
  public errorMsg:any;


  constructor(private abcBankService:AbcBankService,private r:Router) { }

  ngOnInit(): void {
    this.customerName=localStorage.getItem("customerName")
    this.customerId=localStorage.getItem("customerId")
    this.abcBankService.getCustomerDetails(this.customerId).subscribe((result)=>
    {
      console.log(result);
      this.customer=result

    })
  }
  public array:any=[];

  public onUpdate()
  {
    this.customer={
      "dateofbirth":this.customer.dateofbirth,
      "pincode":this.customer.pincode,
      "country":this.customer.country,
      "pancard":this.customer.pancard,
      "address":this.customer.address,
      "phone":this.customer.phone,
      "city":this.customer.city,
      "customerid":this.customer.customerid,
      "customername":this.customer.customername,
      "email":this.customer.email
    }

    console.log(this.customer)
    this.abcBankService.updateCustomerDetails(this.customer).subscribe(result=>{
      console.log(result);
      this.array=JSON.parse(JSON.stringify(result))
      if(this.array['status']=='success')
      {
        this.r.navigate(['menu'])
      }else{
        this.errorMsg=this.array['msg']
      }

    })
  }


}
