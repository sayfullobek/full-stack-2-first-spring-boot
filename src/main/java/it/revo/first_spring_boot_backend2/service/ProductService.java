package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Category;
import it.revo.first_spring_boot_backend2.entity.Products;
import it.revo.first_spring_boot_backend2.pyload.ReqProduct;
import it.revo.first_spring_boot_backend2.pyload.ResProduct;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.repository.CategoryRepository;
import it.revo.first_spring_boot_backend2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<ResProduct> getProduct() {
        List<Products> all = productRepository.findAll();
        List<ResProduct> resProductList = new ArrayList<>();
        int tr = 1;
        for (Products products : all) {
            ResProduct build = ResProduct.builder()
                    .tr(tr)
                    .id(products.getId())
                    .name(products.getName())
                    .price(products.getPrice())
                    .img(products.getImgUrl())
                    .CategoryName(products.getCategory().getName())
                    .build();
            resProductList.add(build);
            tr++;
        }
        return resProductList;
    }

    public Result addProduct(ReqProduct reqProduct) {
        boolean b = productRepository.existsProductsByNameEqualsIgnoreCase(reqProduct.getName());
        Category category = categoryRepository.findById(reqProduct.getCategoryId()).get();
        if (!b) {
            Products products = Products.builder()
                    .category(category)
                    .imgUrl(reqProduct.getImgUrl())
                    .price(reqProduct.getPrice())
                    .build();
            products.setName(reqProduct.getName());
            productRepository.save(products);
            return new Result("Mahsulot Qo'shildi", true);
        }
        return new Result("bunday product avvaldan mavjud", false);
    }
}
