package it.revo.first_spring_boot_backend2.service;

import it.revo.first_spring_boot_backend2.entity.Category;
import it.revo.first_spring_boot_backend2.pyload.ReqCategory;
import it.revo.first_spring_boot_backend2.pyload.ResCategory;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<ResCategory> categoryList() {
        List<Category> all = categoryRepository.findAll();
        List<ResCategory> resCategories = new ArrayList<>();
        int tr = 1;
        for (Category category : all) {
            resCategories.add(
                    ResCategory.builder()
                            .tr(tr)
                            .id(category.getId())
                            .name(category.getName())
                            .build()
            );
            tr++;
        }
        return resCategories;
    }

    public Result addCategory(ReqCategory reqCategory) {
        Category category = new Category(reqCategory.getName());
        categoryRepository.save(category);
        return new Result("saqlandi", true);
    }
}
