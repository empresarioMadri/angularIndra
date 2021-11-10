import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.css']
})
export class CabeceraComponent implements OnInit {

  @Input() cadena:string='';

  contador:number=0;

  @Output() botonPulsado= new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  cambiarPie(){
    this.botonPulsado.emit('Pie cambiado');
  }

  incrementar(){
    this.contador++;
  }

  decrementar(){
    this.contador--;
  }

}
