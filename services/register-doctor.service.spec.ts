import { TestBed } from '@angular/core/testing';

import { RegisterDoctorService } from './register-doctor.service';

describe('RegisterDoctorService', () => {
  let service: RegisterDoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterDoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
