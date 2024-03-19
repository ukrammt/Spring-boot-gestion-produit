package org.xproce.springboot0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproce.springboot0.dao.entities.Product;
import org.xproce.springboot0.dao.repositories.Productrepositories;

import java.util.List;

@SpringBootApplication
public class SpringBoot0Application  implements CommandLineRunner {
    @Autowired
    private  Productrepositories productrepositories;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot0Application.class, args);
    }
    public void run(String[] args){
        //CRUD
        //Create
         Product product=new Product(1L,"P1","Des1",500);
         productrepositories.save(product);
         //Read
        List<Product> productList=productrepositories.findAll();
        productList.forEach(productListFrom-> System.out.println(productListFrom.toString()));
        //Read and find by Id

        Product productById =productrepositories.findById(1L).get();
        System.out.println(productById);

        //Update
        //creation de produit
        Product UpdateProduct = new Product(2L,"P2","des2",600);
        productrepositories.save(UpdateProduct);

        Product productUpdateById =productrepositories.findById(2L).get();
        System.out.println(productUpdateById);

        UpdateProduct.setDescription("setDes");
        System.out.println(UpdateProduct);

        productUpdateById=productrepositories.findById(2L).get();
        System.out.println(productUpdateById);

        //Delete
        Product product1Delete=new Product(3L,"P3","des3",800);
        productrepositories.save(product1Delete);
        System.out.println(productrepositories.findById(3L).get());
        productrepositories.delete(product1Delete);
        try{
            System.out.println(productrepositories.findById(3L).get());
        }catch (Exception exception){
            System.out.println("The product has been deleted");
        }
        Product productDeleteById =new Product(4L,"P4","des4",800);
        productrepositories.save(productDeleteById);
        System.out.println(productrepositories.findById(4L).get());
        productrepositories.deleteById(4L);
        try{
            System.out.println(productrepositories.findById(4L).get());
        }catch (Exception exception){
            System.out.println("The product has been deleted");
        }








    }

}
