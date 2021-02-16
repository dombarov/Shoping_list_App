package examprep.shopinglist.model.service;

import examprep.shopinglist.model.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel extends BaseServiceModel{

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryServiceModel category;

    public ProductServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductServiceModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryServiceModel category) {
        this.category = category;
        return this;
    }
}
