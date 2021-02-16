package examprep.shopinglist.service;

import examprep.shopinglist.model.entity.Category;
import examprep.shopinglist.model.entity.enums.CategoruNameEnum;

public interface CategoryService {

    void initCategories();

    Category findCategoryName(CategoruNameEnum categoruNameEnum);
}
