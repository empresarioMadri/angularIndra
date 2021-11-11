import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'saludo'
})
export class SaludoPipe implements PipeTransform {

  transform(value: any, ...args: unknown[]): unknown {
    return args +' '+ value;
  }

}
