import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AsyncAction } from 'rxjs/internal/scheduler/AsyncAction';

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

saludo = (nombre:string) =>{
  return 'Hola ' + nombre;
}

function saludo2(nombre:string='david'):string{
  return 'Hola ' + nombre;
}

console.log(saludo2());

let empleados:{
  primerApellido:string,
  nombre:string,
  edad:number
}={
  primerApellido:'Robledo',
  nombre:'David',
  edad:47
}

let vacantes:{} = {};

vacantes ={
  nombre:'David'
}

console.log(vacantes);


console.log(arrayNombre[1]);

arrayNombre[3]='Martina';

console.log(arrayNombre[3]);

arrayNombre.push('Sergio');

console.log(arrayNombre[4]);

console.log(arrayNombre.length);

let mapNombres = arrayNombre.map(nombre=>nombre + ' hola');

console.log(mapNombres[0]);

for (let index = 0; index < mapNombres.length; index++) {
  console.log(mapNombres[index]);
}

let capacidades:[string,number];

capacidades = ['programacion',5];

let colores :[number,number,number]=[255,255,0];

let colorFondo :[number,number,number,number?];

colorFondo=colores;
colorFondo[3]=23;

enum Dias {
  lunes=5,
  martes,
  miercoles,
  jueves,
  viernes,
  sabado=0,
  domingo
}

function esFinDeSemana(dia:Dias){
 let isFinDeSemana =false;
 switch (dia) {
   case Dias.lunes:
    case Dias.martes:
      case Dias.miercoles:
        case Dias.jueves:
          case Dias.viernes:
            isFinDeSemana=false;
     break;
  case Dias.sabado:
    case Dias.domingo:
      isFinDeSemana=true;
 } 
 return isFinDeSemana;
}

console.log(esFinDeSemana(5));


const json = '{"latitud":34,"longitud":23}';
const localizacion = JSON.parse(json);

localizacion.latitud = "prueba";

console.log(localizacion);

console.log(localizacion.latitud);

const cadena = JSON.stringify(localizacion);

console.log(cadena);


function escribir(mensaje:string):void{
  console.log(mensaje);
}

escribir("fasdfasdf");


function saltarError(mensaje:string):never{
  throw new Error(mensaje);
}


let bucle = function infinito(){
  while(true){
    console.log('hola');
  }
}

function fn(a:string):boolean{
 if(a == 'si'){
   return true;
  } 
  if(a == 'no'){
    return false;
  }

  return nuncaOcurre();

}

const nuncaOcurre = ()=>{
  throw new Error('No ha ocurrido');
}

type EventosRaton='pulsar'|'arrastrar'|'soltar';

let accion:EventosRaton;

accion='soltar';

if (accion == 'soltar') {
  
} else if(accion=='pulsar'){
  
}else{

}
let contador = 25;
let maximo = 30;

let condicion = contador < maximo?contador++:contador=1;

for (let index = 0; index < arrayNombre.length; index++) {
  const element = arrayNombre[index];
  console.log(element);
}

arrayNombre.forEach(element => {
  console.log(element);
});

let cadenaAux:string = 'soltar';

while(cadenaAux=='soltar' || cadenaAux == 'arrastrar'){
  if(cadenaAux == 'arrastrar'){
    break;
  }
}

do{

}while(cadenaAux=='soltar');

function multiplicar(a:number=45,b:number,c?:number):number{
  if(typeof c !== 'undefined'){
    return a*b*c;
  }else{
    return a*b;
  }
}







