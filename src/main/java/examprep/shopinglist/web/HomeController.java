package examprep.shopinglist.web;

import examprep.shopinglist.model.entity.enums.CategoruNameEnum;
import examprep.shopinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHome(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        } else {

            model.addAttribute("totalSum", productService.getTotalSum());
            model.addAttribute("drinks", productService.findAllProductsByCategoryName(CategoruNameEnum.DRINK));
            model.addAttribute("foods", productService.findAllProductsByCategoryName(CategoruNameEnum.FOOD));
            model.addAttribute("household", productService.findAllProductsByCategoryName(CategoruNameEnum.HOUSEHOLD));
            model.addAttribute("other", productService.findAllProductsByCategoryName(CategoruNameEnum.OTHER));

            return "home";
        }
    }

}
