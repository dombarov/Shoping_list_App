package examprep.shopinglist.service;

import examprep.shopinglist.model.entity.Product;
import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import examprep.shopinglist.model.service.ProductServiceModel;
import examprep.shopinglist.model.view.ProductViewModel;
import examprep.shopinglist.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);

        product.setCategory(this.categoryService.findCategoryName(productServiceModel.getCategory().getName()));

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return this.productRepository.findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoruNameEnum categoruNameEnum) {
        return productRepository.findAllByCategory_Name(categoruNameEnum)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        this.productRepository.deleteAll();;
    }
}
