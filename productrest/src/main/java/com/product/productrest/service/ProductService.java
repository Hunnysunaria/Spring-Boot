package com.product.productrest.service;


import com.product.productrest.model.Product;
import com.product.productrest.repo.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
