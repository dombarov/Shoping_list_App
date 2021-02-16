package examprep.shopinglist.model.service;

import examprep.shopinglist.model.entity.enums.CategoruNameEnum;

public class CategoryServiceModel   {

    private CategoruNameEnum name;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoruNameEnum getName() {
        return name;
    }

    public CategoryServiceModel setName(CategoruNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
