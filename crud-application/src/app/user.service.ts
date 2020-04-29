import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl ="http://localhost:8080/";
  constructor(private http:HttpClient) { }

  createUser(user:any): Observable<any> 
  {
    return this.http.post(`${this.baseUrl}`+'save', user);
  }
}
