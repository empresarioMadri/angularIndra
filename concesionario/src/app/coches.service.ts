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

  incluirCoche(marca_:string,color_:string){
    const body = {'marca':marca_,'color':color_};
    let headers = {'Content-Type': 'application/json'};
    return this.http.post<any>('http://localhost:9090/agregarAngular',body,{headers});
  }
}
