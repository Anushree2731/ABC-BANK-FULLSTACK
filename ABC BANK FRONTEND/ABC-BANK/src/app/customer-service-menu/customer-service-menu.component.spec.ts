import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceMenuComponent } from './customer-service-menu.component';

describe('CustomerServiceMenuComponent', () => {
  let component: CustomerServiceMenuComponent;
  let fixture: ComponentFixture<CustomerServiceMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerServiceMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
