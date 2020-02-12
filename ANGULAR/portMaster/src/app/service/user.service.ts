import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse , HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // private RegisterURL = 'http://localhost:9091/getUser';
  private RegisterURL = 'http://localhost:9091/api/auth/signup';
  private LoginURL = 'http://localhost:9091/api/auth/signin';

  constructor(private http: HttpClient,
              private router: Router) { }

  registerUser(user) {
    return this.http.post<any>(this.RegisterURL, user);

    }

    loginUser(user) {
      return this.http.post<any>(this.LoginURL, user);
        }

        loggedIn() {
          return !!localStorage.getItem('token');
        }
        getToken() {
         return localStorage.getItem('token');
        }
        loggedOutUser() {
          return localStorage.removeItem('token');
          this.router.navigate(['/login']);
         }
}

