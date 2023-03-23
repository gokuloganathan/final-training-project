import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingsDetailsComponent } from './billings-details.component';

describe('BillingsDetailsComponent', () => {
  let component: BillingsDetailsComponent;
  let fixture: ComponentFixture<BillingsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillingsDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillingsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
