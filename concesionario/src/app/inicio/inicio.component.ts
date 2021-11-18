import { Component, OnInit, ViewChild } from '@angular/core';
import { CabeceraComponent } from '../cabecera/cabecera.component';
import { CochesService } from '../coches.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  coches: any;
  id:number=0;
  marca:string='';
  color:string='';
  comercial:number=0;
  cadenaPie:string ='';

  @ViewChild('selector1')
  selector1!: CabeceraComponent;

  ngOnInit(){
    this.cocheServicio.traerCoches().subscribe(
      result=>{
        this.coches=result;
      },
      error=>{
        console.log('Error al recuperar coches');
      }
    )
  }


  constructor(private cocheServicio:CochesService){
    this.coches = [];
  }

  incluirCoche(){
    const coche = new Coche(this.marca,this.color,Coche.ultimaPosicion);
    this.cocheServicio.incluirCoche(this.marca,this.color,this.comercial,this.id).subscribe(
      result=>{
        console.log(result);
        this.marca='';
        this.id=0;
        this.color='';
        this.cocheServicio.traerCoches().subscribe(
          result=>{
            this.coches=result;
          },
          error=>{
            console.log('Error al recuperar coches');
          }
        )
      },
      error=>{
        console.log(error);
      }
    );
  }

  modificar(indice:number){
    const posicion = this.coches[indice];
    if(this.marca)
      posicion.marca = this.marca;
    if(this.color)
      posicion.color = this.color;
  }

  borrar(indice:number){
    this.cocheServicio.borrarCoche(this.coches[indice].id).subscribe(
      result=>{
        this.cocheServicio.traerCoches().subscribe(
          result=>{
            this.coches=result;
          },
          error=>{
            console.log('Error al recuperar coches');
          }
        )
      },
      error=>{
        console.log('Error al borrar un coche');
      }
    )
  }

  modificarCoche(indice:number){
    this.marca = this.coches[indice].marca;
    this.color = this.coches[indice].color;
    this.id = this.coches[indice].id;
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
  private _comercial:number=0;
  private _id:number=0;
  private _posicion:number=0;
  static ultimaPosicion:number=0;

  constructor(marca:string,color:string,posicion:number){
    this._marca=marca;
    this._color=color;
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

  public set comercial(comercial:number){
    this._comercial=comercial;
  }

  public set id(id:number){
    this._id=id;
  }

  public set posicion(posicion:number){
    this._posicion=posicion;
  }

  

}

