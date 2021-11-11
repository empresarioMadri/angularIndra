import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  nombre:string = 'David';
  saldo = 150.5;
  dias=['lunes','martes','miercoles','jueves','viernes','sabado','domingo'];

  coches=[
    {marca:'seat',color:'rojo'},
    {marca:'opel',color:'azul'}
  ]

  fechaActual = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
