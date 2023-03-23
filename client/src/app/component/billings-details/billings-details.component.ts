import {Component, Input} from '@angular/core';
import {Billing} from "../../modal/billing.modal";
import {BillingServiceService} from "../../service/billing-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-billings-details',
  templateUrl: './billings-details.component.html',
  styleUrls: ['./billings-details.component.css']
})
export class BillingsDetailsComponent {
  @Input() viewMode = false;

  @Input() currentBilling: Billing = {
    billerName:'',
    billAmount:0,
    billPaid:false
  };

  message = '';

  constructor(
    private billingService: BillingServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      //console.log('route : '+this.route.snapshot.params["id"])
      this.getBilling(this.route.snapshot.params["id"]);
    }
  }

  getBilling(id: string): void {
    this.billingService.get(id)
      .subscribe({
        next: (data) => {
          this.currentBilling = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updatePaid(status: boolean): void {
    const data : Billing = {
      billerName: this.currentBilling.billerName,
      billAmount: this.currentBilling.billAmount,
      billPaid: status
    };


    this.message = '';

    console.log(data)
    this.billingService.update(this.currentBilling.billId, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentBilling.billPaid = status;
          this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  updateBilling(): void {
    this.message = '';

    this.billingService.update(this.currentBilling.billId, this.currentBilling)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'bill payment updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteBilling(): void {
    this.billingService.delete(this.currentBilling.billId)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/billings']);
        },
        error: (e) => console.error(e)
      });
  }
}
