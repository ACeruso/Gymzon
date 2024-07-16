package Controller;

import jakarta.servlet.http.HttpServletRequest;

public class CommonValidator {
    public static RequestValidator validateId(HttpServletRequest request){
        RequestValidator validator = new RequestValidator(request);
        validator.assertInt("id", "id deve essere un formato valido");
        return validator;

    }
}
