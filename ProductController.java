/*package com.SpringWebApp.SpringWebApp.Controller;

import com.SpringWebApp.SpringWebApp.Model.Product;
import com.SpringWebApp.SpringWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @RequestMapping("/products")
    public List<Product> getProducts(){
        return service.getProductlist();
    }
}
*/
package com.SpringWebApp.SpringWebApp.Controller;

import com.SpringWebApp.SpringWebApp.Exception.ProductNotFoundException;
import com.SpringWebApp.SpringWebApp.Exception.ResponseBuilder;
import com.SpringWebApp.SpringWebApp.Model.Product;
import com.SpringWebApp.SpringWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//16-05-2025 (Controller layer testCases)
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getProductlist();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product/{id}")//An important one
    @ResponseBody// This will return JSON for now; remove @ResponseBody if you want to render HTML view
    public ResponseEntity<Object>  getProductByID(@PathVariable("id") int id) {
        return ResponseBuilder.responseBuilder("Requested Vendor Details are provided here",HttpStatus.ACCEPTED ,productService.getProductByID(id));
        //return new ProductNotFoundException("Product with ID " + id + " not found"));
    }
    @PostMapping("/products/{id}")
    @ResponseBody
    public Product addProduct(@RequestBody Product prod) {
        System.out.println(prod);
        productService.addProduct(prod);
        System.out.println("Product added successfully");//check this for fit
        return prod;
    }
    @PutMapping("/products/{id}")
    @ResponseBody
    public String updateProduct(@PathVariable int id, @RequestBody Product prod) {
        boolean updated = productService.updateProduct(id,prod);
        return updated ? "Product updated successfully" : "Product not found";
    }
    @DeleteMapping("/products/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable int id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }
    //public void showHistory(){

    //}

//continue tomorrow
    //custom response handler needs to be added
    //unit testing should be done

}

//adding exception handler for better understanding of client

