import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRemoveExamComponent } from './admin-remove-exam.component';

describe('AdminRemoveExamComponent', () => {
  let component: AdminRemoveExamComponent;
  let fixture: ComponentFixture<AdminRemoveExamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminRemoveExamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRemoveExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
