import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  formularioVentas = new FormGroup({
    venta:new FormControl(''),
    email :new FormControl('')
  })

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
    this.listaVentas.push(this.formularioVentas.value.venta + '-' + this.formularioVentas.value.email);
    localStorage.setItem('ventas',JSON.stringify(this.listaVentas));
    this.formularioVentas.value.venta = '';
    this.formularioVentas.value.email = '';
  }

  borrar(posicion:number){
    this.listaVentas.splice(posicion,1);
    localStorage.clear();
    localStorage.setItem('ventas',JSON.stringify(this.listaVentas));
  }

}
