import {Injectable} from '@angular/core';
import { HttpClient, HttpErrorResponse , HttpHeaders} from '@angular/common/http';
import { IPortfolioStatic } from '../portfolioStatic';
import { Observable, observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';



@Injectable()
export class PortfolioStaticService {

private _URL = 'http://localhost:9091/api/auth/getPortfolio';

constructor(private http: HttpClient) {}

getPortfolio(): Observable<IPortfolioStatic[]> {
return this.http.get<IPortfolioStatic[]> (this._URL ).pipe
                  (catchError(this.errorHandler));

}

errorHandler(error: HttpErrorResponse) {

return throwError(error.message || 'server error');

}

handleError(error: HttpErrorResponse) {
    console.log('error');
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  deletePortfolio(Id: string): Observable<{}> {

    const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };
    const url = `http://localhost:9091/api/auth/getPortfolio/${Id}`;
    return this.http.delete(url, httpOptions).pipe
    (catchError(this.errorHandler));
}


createPortfolio(data)  {
  let existsCheck: boolean;
  const httpHeaders = new HttpHeaders().set(
        'Content-Type',
        'application/json'
    );
  console.log('I am here');
  this.http.post(this._URL,  data,
    {
        observe: 'response',
        headers: httpHeaders
       }).subscribe(
        responseData => {
            if (responseData.status === 200) {
                existsCheck = true;
            } else {
                existsCheck = false;
            }
        },
        error => {
            console.log('Error with post button', existsCheck);
        }
    );

}


}
