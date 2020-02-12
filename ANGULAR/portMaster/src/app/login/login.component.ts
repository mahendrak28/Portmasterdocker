import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService} from '../service/user.service';
import { HttpErrorResponse } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  showErrorMessage = false;
  loginUserData = {username: '',
  password: '' };

    constructor(private auth: UserService,
                private router: Router) { }

    ngOnInit() {
    }

    loginUser() {
      this.auth.loginUser(this.loginUserData)
      .subscribe(
        res =>  {
         localStorage.setItem('token', res.accessToken);
         console.log(res);
         this.router.navigate(['/PortfolioStatic']);
       },
        err => {
          console.log(err);
          if (err instanceof HttpErrorResponse) {
            if (err.status === 401) {
              console.log('User is not Authorized');
              this.showErrorMessage = true;
            }
          }
        }
      );
       }

}
