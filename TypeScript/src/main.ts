import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));


console.log('-------Tipos typescript--------')

function sumar(x:number,y:number){
  return x+y;
}

let val1 = (<HTMLInputElement>document.getElementById('value1')).value;
let val2 = (<HTMLInputElement>document.getElementById('value2')).value;

console.log(sumar(parseInt(val1),parseInt(val2)));



