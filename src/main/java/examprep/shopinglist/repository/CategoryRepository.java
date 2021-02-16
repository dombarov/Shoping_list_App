package examprep.shopinglist.repository;

import examprep.shopinglist.model.entity.Category;
import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoruNameEnum categoruNameEnum);
}

