import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  @Input() coches:any;

  @Output() modificarCocheListado= new EventEmitter();

  @Output() borrarCocheListado= new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  modificar(indice:number){
    this.modificarCocheListado.emit(indice);
  }

  borrar(indice:number){
    this.borrarCocheListado.emit(indice);
  }

}
