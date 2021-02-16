package examprep.shopinglist.repository;

import examprep.shopinglist.model.entity.Product;
import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select SUM(s.price) from Product s ")
    BigDecimal findTotalProductSum();

    List<Product> findAllByCategory_Name(CategoruNameEnum categoruNameEnum);
}
