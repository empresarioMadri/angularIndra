import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pie',
  templateUrl: './pie.component.html',
  styleUrls: ['./pie.component.css']
})
export class PieComponent implements OnInit {

  @Input() cadena:string='Pie de pagina ';

  constructor() { }

  ngOnInit(): void {
  }

  public get cadenaConcatenada():string{
    return 'Pie de pagina ' + this.cadena;
  }

}
