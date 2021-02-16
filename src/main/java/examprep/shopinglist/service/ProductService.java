package examprep.shopinglist.service;

import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import examprep.shopinglist.model.service.ProductServiceModel;
import examprep.shopinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);
    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoruNameEnum categoruNameEnum);

    void buyById(String id);

    void buyAll();
}
