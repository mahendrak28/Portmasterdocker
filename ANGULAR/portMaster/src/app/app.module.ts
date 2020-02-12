import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PortfolioStaticComponent } from './portfolio-static/portfolio-static.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { PortfolioStaticService } from './service/portfolioStatic.service';
import { UserService} from './service/user.service';

import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AgGridModule } from 'ag-grid-angular';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';
import { TokenInterceptorService } from './service/token-interceptor.service';



@NgModule({
  declarations: [
    AppComponent,
    PortfolioStaticComponent,
    PortfolioDetailsComponent,
    PageNotFoundComponent,
    LoginComponent,
    RegisterComponent
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AgGridModule.withComponents([])
  ],
  providers: [PortfolioStaticService, UserService, AuthGuard,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
