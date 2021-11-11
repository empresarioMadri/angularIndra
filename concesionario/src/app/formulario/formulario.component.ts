import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ValidacionEmail } from '../validacion-email';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  formularioVentas = new FormGroup({
    venta:new FormControl('',[Validators.required,Validators.minLength(10)]),
    email :new FormControl('',[ValidacionEmail.validar]),
    decisiones:new FormGroup({
      quiereComprar:new FormControl('si'),
      escogido:new FormControl(true)
    })
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
    this.listaVentas.push(this.formularioVentas.value.venta + '-' + this.formularioVentas.value.email + '-' + this.formularioVentas.value.decisiones.quiereComprar + '-' + this.formularioVentas.value.decisiones.escogido);
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
