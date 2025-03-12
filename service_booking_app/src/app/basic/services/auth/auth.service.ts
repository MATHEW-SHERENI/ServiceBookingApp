import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL="https://localhost:8080/";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient,) { }

  registerClient(signupRequestDTO:any):Observable<any>{
    return this.http.post(BASIC_URL + "Client/sign-up", signupRequestDTO);
  }

  registerCompany(signupRequestDTO:any):Observable<any>{
    return this.http.post(BASIC_URL + "Company/sign-up", signupRequestDTO);
  }
}
