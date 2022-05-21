import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AbcBankService } from '../abc-bank.service';

@Component({
  selector: 'app-customer-service-menu',
  templateUrl: './customer-service-menu.component.html',
  styleUrls: ['./customer-service-menu.component.css']
})
export class CustomerServiceMenuComponent implements OnInit {
  customerName:any;
  constructor(private abcBankService:AbcBankService, private route:Router) { }

  ngOnInit(): void {
    this.customerName=localStorage.getItem("customerName")

  }
  logOut() {
    this.abcBankService.setUserStatus(false)
    this.route.navigate([""])
    window.location.reload();
  }

}

