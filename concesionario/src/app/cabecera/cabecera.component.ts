import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.css']
})
export class CabeceraComponent implements OnInit {

  @Input() cadena:string='';

  @Output() botonPulsado= new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  cambiarPie(){
    this.botonPulsado.emit('Pie cambiado');
  }

}
