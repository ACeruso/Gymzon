package Controller;

import jakarta.servlet.http.HttpServletRequest;

public class UtenteValidator {

    static RequestValidator validateSignin(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertInt("id", "Id deve essere un intero");
        validator.assertEmail("email", "Formato non corretto");
        return validator;
    }
}
