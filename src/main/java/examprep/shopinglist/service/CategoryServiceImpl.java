package examprep.shopinglist.service;

import examprep.shopinglist.model.entity.Category;
import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import examprep.shopinglist.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService{
        private final CategoryRepository categoryRepository;
        private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count()==0){
            Arrays.stream(CategoruNameEnum.values())
                    .forEach(categoruNameEnum -> {
                        this.categoryRepository.save(new Category(categoruNameEnum,
                                String.format("Description for %s", categoruNameEnum.name())));
                    });

        }
    }

    @Override
    public Category findCategoryName(CategoruNameEnum categoruNameEnum) {
        return this.categoryRepository.findByName(categoruNameEnum).orElse(null);
    }
}
