import { Component } from '@angular/core';
import {Billing} from "../../modal/billing.modal";
import {BillingServiceService} from "../../service/billing-service.service";

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']
})
export class AddBillComponent {

  billing: Billing = {
    billerName: '',
    billAmount: 0,
    billPaid: false
  };
  submitted = false;

  constructor(private billingService:BillingServiceService) { }

  saveBilling(): void {
    const data = {
      billerName:this.billing.billerName,
      billAmount:this.billing.billAmount
    };

    this.billingService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newBilling(): void {
    this.submitted = false;
    this.billing = {
      billerName: '',
      billAmount: 0,
      billPaid: false
    };
  }

}
