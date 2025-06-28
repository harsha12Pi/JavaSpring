package com.SpringWebApp.SpringWebApp.Exception;

import com.SpringWebApp.SpringWebApp.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ProductExceptionHandler {
    @GetMapping("/products{id}")
    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<ProductException> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ProductException productException = new ProductException(
                productNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                productNotFoundException.getCause()
        );
        return new ResponseEntity<>(productException, HttpStatus.NOT_FOUND);
    }

}
