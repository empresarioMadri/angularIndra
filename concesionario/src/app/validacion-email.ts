import { FormControl, ValidationErrors } from "@angular/forms";

export class ValidacionEmail {
    static validar(control:FormControl):ValidationErrors{
        if(!control.value){
            return {validar:false};
        }else{
            return {validar:control.value.indexOf('@')>=0};
        }
    }
}
