import { Component } from '@angular/core';
import {Billing} from "../../modal/billing.modal";
import {BillingServiceService} from "../../service/billing-service.service";

@Component({
  selector: 'app-billings-list',
  templateUrl: './billings-list.component.html',
  styleUrls: ['./billings-list.component.css']
})
export class BillingsListComponent {
  billings?: Billing[];
  currentBilling: Billing = {};
  currentIndex = -1;
  billerName = '';

  constructor(private billingService: BillingServiceService) { }

  ngOnInit(): void {
    this.retrieveBillings();
  }

  retrieveBillings(): void {
    this.billingService.getAll()
      .subscribe({
        next: (data) => {
          this.billings = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  refreshList(): void {
    this.retrieveBillings();
    this.currentBilling = {};
    this.currentIndex = -1;
  }

  setActivebilling(billing: Billing, index: number): void {
    this.currentBilling = billing;
    this.currentIndex = index;
  }

  removeAllbillings(): void {
    this.billingService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  searchName(): void {
    this.currentBilling = {};
    this.currentIndex = -1;

    this.billingService.findByBillerName(this.billerName)
      .subscribe({
        next: (data) => {
          this.billings = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
}
