package com.hunny.EcomProj.Controller;

import com.hunny.EcomProj.model.Product;
import com.hunny.EcomProj.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;



    @GetMapping("/products")
    public ResponseEntity<List<Product>> products(){
        System.out.println(service.getAllProd());
        return new ResponseEntity<>(service.getAllProd(), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProd(@PathVariable int id) {
        Product prod = service.getProduct(id);

        if (prod != null)
            return new ResponseEntity<>(prod, HttpStatusCode.valueOf(200));
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]>getImage(@PathVariable int id){


            return new ResponseEntity<>(service.getProduct(id).getImageData(),HttpStatus.FOUND);


    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String>updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imagefile){
        try {
            Product prod= service.addorUpdateProduct(product,imagefile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return new ResponseEntity<>("Updated",HttpStatus.OK);

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile makefile){

        try{
            Product savedProduct= service.addorUpdateProduct(product, makefile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProd(@PathVariable int id){

       
        service.deleteProd(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);

    }

}
