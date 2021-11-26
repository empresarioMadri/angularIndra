import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formularioLogin=new FormGroup({
    usuario:new FormControl('',[Validators.required]),
    clave:new FormControl('',[Validators.required]),
    mantenerConectado:new FormControl('false')
  })

  constructor(private loginService:LoginService) {
        
  }

  ngOnInit(): void {
  }

  login(){
      this.loginService.login(this.formularioLogin.get('usuario')?.value,this.formularioLogin.get('clave')?.value).subscribe(
        result=>{
          console.log('logueado ' + result);
        },
        error=>{
            console.log('Error ' + error);
        }
      )
  }

  get usuario(){
    return this.formularioLogin.get('usuario');
  }

  get clave(){
    return this.formularioLogin.get('clave');
  }



}
