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

  incluirCoche(marca_:string,color_:string,comercial_:number,id_?:number){
    const body = {'marca':marca_,'color':color_,'comercial':comercial_,'id':id_};
    let headers = {'Content-Type': 'application/json'};
    return this.http.post<any>('http://localhost:9090/agregarAngular',body,{headers});
  }

  borrarCoche(id_:number){
    return this.http.delete<any>('http://localhost:9090/borrarAngular/' + id_);
  }
}
