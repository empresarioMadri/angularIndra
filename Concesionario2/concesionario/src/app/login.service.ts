import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


  login(usuario_:string,clave_:string){
    const body={'usuario':usuario_,'clave':clave_};
    let headers = {'Content-Type': 'application/json'};
    return this.http.post('http://localhost:9091/login',body,{headers});
  }
}
