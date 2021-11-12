import { AbstractControl, ValidationErrors } from "@angular/forms";

export class ValidacionEmail {
    static validar(control:AbstractControl):ValidationErrors|null{
        if(!control.value){
            return null;
        }else if(control.value.indexOf('@')<0){
            return {validar:true};
        }
        return null;
    }
}
