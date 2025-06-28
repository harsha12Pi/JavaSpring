/*package com.SpringWebApp.SpringWebApp.Service;

import com.SpringWebApp.SpringWebApp.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {
    List<Product> productlist = Arrays.asList(
            new Product(101,"Laptop",67000),
            new Product(102,"KeyBoard",1200),
            new Product(103,"TV",89000),
            new Product(104,"AC",85000));


    public List<Product> getProductlist() {
        return productlist;
    }

    public Product getProductID(){
        return productlist.stream().filter(p -> p.getProdID() == ProdID)
    }
}*/

package com.SpringWebApp.SpringWebApp.Service;

import com.SpringWebApp.SpringWebApp.Exception.ProductNotFoundException;
import com.SpringWebApp.SpringWebApp.Model.Product;
import com.SpringWebApp.SpringWebApp.Repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepo repo;
    //        new Product(101, "Laptop", 67000),
    //private final List<Product> productlist = new ArrayList<>(Arrays.asList(
      //      new Product(102, "KeyBoard", 1200),
        //    new Product(103, "TV", 89000),
          //  new Product(104, "AC", 85000)
    //));

    public List<Product> getProductlist() {
        return repo.findAll();
    }

    public Product getProductByID(int prodID) {
        logger.info("Product has been initialized");
        logger.debug("Debugging has been initialized");
        if(repo.findById(prodID).isEmpty())
            throw new ProductNotFoundException("Requested Product Not Found");
        return repo.findById(prodID).get();//stream()
                //.filter(p -> p.getProdID() == prodID)
                //.findFirst()
                //.orElse(new Product(100,"NoProductIsAvailable",69));  // Return null or throw custom exception
    }

  public void addProduct(Product prod){
        repo.save(prod);
        //productlist.add(prod);
  }
    /*public boolean updateProductById(int id, Product updatedProduct) {
        for (Product p : productlist) {
            if (p.getProdID() == id) {
                p.setProdName(updatedProduct.getProdName());
                p.setPrice(updatedProduct.getPrice());
                return true;
            }
        }
        return false; // Product not found
    }*/
    public boolean updateProduct(int ProdID,Product prod){
        repo.save(prod);
        return true;
    }
    /*
    public boolean productDeletedById(int id){
        return productlist.removeIf(p ->p.getProdID() == id);
    }*/
    public boolean deleteProduct(int ProdID){
        repo.deleteById(ProdID);
        return true;
    }
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

}

