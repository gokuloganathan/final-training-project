import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddBillComponent} from "./component/add-bill/add-bill.component";
import {BillingsListComponent} from "./component/billings-list/billings-list.component";
import {BillingsDetailsComponent} from "./component/billings-details/billings-details.component";

const routes: Routes = [
  { path: '', redirectTo: 'billings', pathMatch: 'full' },
  {path:'billings',component:BillingsListComponent},
  {path:'billings/:id',component:BillingsDetailsComponent},
  {path:'add',component:AddBillComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
