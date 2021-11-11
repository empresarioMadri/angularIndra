import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { CabeceraComponent } from './cabecera/cabecera.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  coches: any;
  marca:string='';
  color:string='';
  cadenaPie:string ='';

  @ViewChild('selector1')
  selector1!: CabeceraComponent;

  ngOnInit(){
    this.http.get("http://localhost:9090/coches")
    .subscribe(
      result=>{
        this.coches=result;
      },
      error=>{
        console.log('Error al recuperar coches');
      }
    )
  }


  constructor(private http:HttpClient){
    this.coches = [];
  }

  incluirCoche(){
    const coche = new Coche(this.marca,this.color,Coche.ultimaPosicion);
    Coche.ultimaPosicion++;
    this.coches.push(coche);
  }

  modificar(indice:number){
    const posicion = this.coches[indice];
    if(this.marca)
      posicion.marca = this.marca;
    if(this.color)
      posicion.color = this.color;
  }

  borrar(indice:number){
    this.coches.splice(indice,1);
    Coche.ultimaPosicion--;
    for (let index = 0; index < this.coches.length; index++) {
      const coche = this.coches[index];
      coche.posicion=index;
    }
  }

  cambiarPie(cadena:string){
    this.cadenaPie=cadena;
  }

  incrementar(){
    this.selector1.incrementar();
  }

  decrementar(){
    this.selector1.decrementar();
  }


}

class Coche{
  private _marca:string;
  private _color:string;
  private _posicion:number;
  static ultimaPosicion:number=0;

  constructor(marca:string,color:string,posicion:number){
    this._marca=marca;
    this._color=color;
    this._posicion=posicion;
  }

  public get marca():string{
    return this._marca;
  }

  public get color():string{
    return this._color;
  }

  public set marca(marca:string){
    this._marca=marca;
  }

  public set color(color:string){
    this._color=color;
  }

  public get posicion():number{
    return this._posicion;
  }

  public set posicion(posicion:number){
    this._posicion=posicion;
  }

}
