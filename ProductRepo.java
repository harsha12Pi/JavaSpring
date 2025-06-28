/*package com.SpringWebApp.SpringWebApp.Repository;

import com.SpringWebApp.SpringWebApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}*/
package com.SpringWebApp.SpringWebApp.Repository;

import com.SpringWebApp.SpringWebApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByProdName(String productName); // <-- Custom query method
}

