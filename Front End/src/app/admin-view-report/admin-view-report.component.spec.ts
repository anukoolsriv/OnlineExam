import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewReportComponent } from './admin-view-report.component';

describe('AdminViewReportComponent', () => {
  let component: AdminViewReportComponent;
  let fixture: ComponentFixture<AdminViewReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
