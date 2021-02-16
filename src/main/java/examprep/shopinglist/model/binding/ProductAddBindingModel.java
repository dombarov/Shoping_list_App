package examprep.shopinglist.model.binding;

import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoruNameEnum category;

    public ProductAddBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters.")
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 5, message = "Description legth must be minimum 5 characters.")
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "the date connot be in the past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    @DecimalMin(value = "0", message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoruNameEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoruNameEnum category) {
        this.category = category;
        return this;
    }
}
