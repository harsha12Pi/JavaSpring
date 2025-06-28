package com.SpringWebApp.SpringWebApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
@Data
@Entity
public class Product {
    private static final Logger logInfo = LoggerFactory.getLogger(Product.class);
    @Id
    private int prodID;
    private int price;
    private String prodName;

    public Product() {

    }

    public Product(int prodID, String prodName, int price) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdID() {
        logInfo.info("Product has been initialized");
        logInfo.debug("Product has been Debugged");
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodID=" + prodID +
                ", price=" + price +
                ", prodName='" + prodName + '\'' +
                '}';
    }
}
