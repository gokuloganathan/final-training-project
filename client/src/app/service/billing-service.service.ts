import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Billing} from "../modal/billing.modal";

const baseUrl = 'http://localhost:8085/api/v1/bills';

@Injectable({
  providedIn: 'root'
})
export class BillingServiceService {
  constructor(public http:HttpClient) {

  }
  getAll():Observable<Billing[]>{
    return this.http.get<Billing[]>(baseUrl);
  }


  get(id: any): Observable<Billing> {
    return this.http.get<Billing>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
/*    console.log(data.billId+" from service")
    console.log(data.billerName+" from service")
    console.log(data.billAmount+" from service")
    console.log(data.billPaid+" from service")*/

    return this.http.put(`${baseUrl}/${id}`,data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    console.log(baseUrl)
    return this.http.delete(baseUrl);
  }

  findByBillerName(name: any): Observable<Billing[]> {
    //console.log(this.http.get<Billing[]>(`${baseUrl}?name=${name}`))
    return this.http.get<Billing[]>(`${baseUrl}?name=${name}`);
  }
}
