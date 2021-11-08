import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  coches: Coche[];
  marca:string='';
  color:string='';

  constructor(){
    this.coches = [];
  }

  incluirCoche(){
    const coche = new Coche(this.marca,this.color);
    this.coches.push(coche);
  }


}

class Coche{
  private _marca:string;
  private _color:string;

  constructor(marca:string,color:string){
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

}
