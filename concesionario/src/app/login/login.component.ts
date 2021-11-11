import { Component, OnInit } from '@angular/core';
import { NgbCalendar, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

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

  ngOnInit(): void {
  }

  model!: NgbDateStruct;
  date!: {year: number, month: number};

  constructor(private calendar: NgbCalendar) {
  }

  selectToday() {
    this.model = this.calendar.getToday();
  }

}
