import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortfolioStaticComponent } from './portfolio-static.component';

describe('PortfolioStaticComponent', () => {
  let component: PortfolioStaticComponent;
  let fixture: ComponentFixture<PortfolioStaticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortfolioStaticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortfolioStaticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
