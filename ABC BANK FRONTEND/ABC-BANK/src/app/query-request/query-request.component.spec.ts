import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryRequestComponent } from './query-request.component';

describe('QueryRequestComponent', () => {
  let component: QueryRequestComponent;
  let fixture: ComponentFixture<QueryRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QueryRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QueryRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
