package examprep.shopinglist.model.entity;

import examprep.shopinglist.model.entity.enums.CategoruNameEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoruNameEnum name;
    private String description;

    public Category() {
    }

    public Category(CategoruNameEnum name, String description) {
        this.name = name;
        this.description = description;
    }

    @Enumerated
    public CategoruNameEnum getName() {
        return name;
    }

    public Category setName(CategoruNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
