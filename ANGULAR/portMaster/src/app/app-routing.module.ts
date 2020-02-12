import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PortfolioStaticComponent } from './portfolio-static/portfolio-static.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {path: 'login', component : LoginComponent},
  {path: 'register', component : RegisterComponent},
  {path: 'PortfolioStatic', component : PortfolioStaticComponent, canActivate: [AuthGuard] },
  {path: 'PortfolioDetails',  component: PortfolioDetailsComponent},
  {path: '**',  component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
