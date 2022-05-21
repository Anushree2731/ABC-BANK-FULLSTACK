import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StolenOrLostComponent } from './stolen-or-lost.component';

describe('StolenOrLostComponent', () => {
  let component: StolenOrLostComponent;
  let fixture: ComponentFixture<StolenOrLostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StolenOrLostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StolenOrLostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
