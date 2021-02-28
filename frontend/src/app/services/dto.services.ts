import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Observable,throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  getBook(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }

  createBook(book: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/save`, book);
  }

  updateBook( value: any, id: number): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  /*getBooksList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getall`);
  }*/

  getBooksList(page:number, size:number, order:string, asc:boolean): Observable<any> {
    return this.http.get(`${this.baseUrl}/getall`+`?page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}





/*@Injectable()
export class DtoService {
    //localhost:8080/api/books/Libro2
  url = 'http://localhost:8080/api/books/';

  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }
    )
  };

  constructor(private http: HttpClient) {
  }

  execGetById(params:any): Observable<any> {
    return this.http.get<any>(this.url + params, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  execGetAll(): Observable<any> {
    return this.http.get<any>(this.url, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  execPost(params:any, data:any) {
    const rq =JSON.stringify(data);

  return  this.http.post(this.url+params ,rq, {​​ headers: new HttpHeaders({​​ 'Content-Type': 'application/json' }​​) }​​)
  .pipe(
    catchError(this.handleError)
  );
      //return this.http.post(this.urlConsultar, rq, {​​headers : new HttpHeaders({​​ 'Content-Type': 'application/json' }​​),withCredentials:true}​​)
  }
      

  execPut(params:any, data:any): Observable<any> {
    return this.http.put(this.url + params, data, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }

  execDeleteId(params:any): Observable<any> {
    return this.http.delete(this.url + params, this.httpOptions);
  }


  handleError(error: HttpErrorResponse) {
    let resp: any;
    if (error.error instanceof ErrorEvent) {
      resp = {status: 'Error', message: error.error.message, code: '500'};
    } else {
      resp = {status: 'Error del Backend!', message: error.error.message, code: error.status};
      if (error.status === 401) {
        sessionStorage.clear();
        window.location.href = '/';
      }
    }
    return throwError(resp);
  }


}*/
