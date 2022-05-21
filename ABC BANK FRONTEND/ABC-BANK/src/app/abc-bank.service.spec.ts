import { TestBed } from '@angular/core/testing';

import { AbcBankService } from './abc-bank.service';

describe('AbcBankService', () => {
  let service: AbcBankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AbcBankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
