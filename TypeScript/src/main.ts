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

console.log(typeof(val1));

console.log('-------Tipos typescript dinamicos--------')

interface Producto{
  id:number,
  nombre:string,
  precio:number
};

function getProducto(id:number):Producto{
  return{
    id:id,
    nombre:'Producto' + id,
    precio:65
  }
}

const producto = getProducto(1);
console.log('El producto ' + producto.nombre + ' cuesta ' + producto.precio);

const presentarProducto = (nombre:string,precio:number)=>{
  return 'El producto ' + nombre + ' cuesta ' + precio;
}

console.log(presentarProducto(producto.nombre,producto.precio));

let nombreVariable:any;

let nombreVariable2:string = 'nombre';

const nombreVariable3:boolean = true;

nombreVariable = true;
nombreVariable2='nombre22';

let arrayNombre:string[] = ['David','Maria','Victor'];

let persona:{
  nombre:string,
  edad:number
}

persona={
  nombre:'David',
  edad:47
}

let saludo:(nombre:string)=>string;

saludo = function(nombre:string){
  return 'Hola ' + nombre;
}

console.log(saludo('david'));








