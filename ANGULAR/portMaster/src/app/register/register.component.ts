import { Component, OnInit } from '@angular/core';
import { UserService} from '../service/user.service';
import { Router } from '@angular/router' ;

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerUserData = { username: '',
  password: '',
email: ''};
  constructor(private auth: UserService,
              private router: Router) { }

  ngOnInit() {
  }
  registerUser() {
    this.auth.registerUser(this.registerUserData)
      .subscribe(
        res =>  {
         localStorage.setItem('token', res.accessToken);
         console.log(res);
         this.router.navigate(['/PortfolioStatic']);
       },
        err => console.log(err)
      );
     }
}
