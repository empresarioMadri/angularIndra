import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CochesService {

  constructor(private http:HttpClient) { }

  traerCoches(){
    return this.http.get("http://localhost:9090/coches");
  }
}
