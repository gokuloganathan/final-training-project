import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingsListComponent } from './billings-list.component';

describe('BillingsListComponent', () => {
  let component: BillingsListComponent;
  let fixture: ComponentFixture<BillingsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillingsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillingsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
