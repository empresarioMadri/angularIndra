import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  ventas = new FormControl();

  listaVentas! : string[];

  constructor() {

  }

  ngOnInit(): void {
    this.listaVentas=[];
    let ventasGuardadas = JSON.parse(localStorage.getItem('ventas') || '');
    for (let venta of ventasGuardadas) {
      this.listaVentas.push(venta);
    }
  }

  agregar(){
    this.listaVentas.push(this.ventas.value);
    localStorage.setItem('ventas',JSON.stringify(this.listaVentas));
    this.ventas.setValue('');
  }

  borrar(posicion:number){
    this.listaVentas.splice(posicion,1);
    localStorage.clear();
    localStorage.setItem('ventas',JSON.stringify(this.listaVentas));
  }

}
