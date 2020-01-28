import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserExamQuestionsComponent } from './user-exam-questions.component';

describe('UserExamQuestionsComponent', () => {
  let component: UserExamQuestionsComponent;
  let fixture: ComponentFixture<UserExamQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserExamQuestionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserExamQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
