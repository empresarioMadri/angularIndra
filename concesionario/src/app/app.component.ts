import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'concesionario';
  nombre = 'Proyecto hola mundo inicial';
  precioCoches =  [1330,500,200];
  numeroCoches = 0;

  sumaPrecios():number{
    let suma =0;
    this.precioCoches.forEach((num)=>suma+=num);
    return suma;
  }

  incrementar(){
    this.numeroCoches++;
  }

  decrementar(){
    this.numeroCoches--;
  }



}
