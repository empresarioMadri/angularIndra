import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { PieComponent } from './pie/pie.component';
import { ConcesionarioModule } from './concesionario/concesionario.module';

@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    PieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ConcesionarioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
