import { AbstractControl, ValidationErrors } from "@angular/forms";

export class ValidacionEmail {
    static validar(control:AbstractControl):ValidationErrors{
        if(!control.value){
            return {validar:false};
        }else{
            return {validar:control.value.indexOf('@')<0};
        }
    }
}
