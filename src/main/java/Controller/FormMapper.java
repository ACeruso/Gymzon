package Controller;

import jakarta.servlet.http.HttpServletRequest;

public interface FormMapper<T> {
    T map(HttpServletRequest request, boolean update);

}

