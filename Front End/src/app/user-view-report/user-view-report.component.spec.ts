import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewReportComponent } from './user-view-report.component';

describe('UserViewReportComponent', () => {
  let component: UserViewReportComponent;
  let fixture: ComponentFixture<UserViewReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserViewReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
