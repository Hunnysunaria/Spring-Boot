package com.hunny.EcomProj.service;

import com.hunny.EcomProj.model.Product;
import com.hunny.EcomProj.repo.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductService {

    @Autowired
private ProdRepo repo;
    public List<Product> getAllProd() {
        return repo.findAll();

    }

    public Product getProduct(int id) {

        return repo.findById(id).orElse(new Product(-1));
    }

    public Product addorUpdateProduct(Product product, MultipartFile image) throws IOException {
    product.setImageName(image.getOriginalFilename());
    product.setImageType(image.getContentType());
    product.setImageData(image.getBytes());

return repo.save(product);
    }

    public void deleteProd(int Id) {

        repo.deleteById(Id);
    }
}
