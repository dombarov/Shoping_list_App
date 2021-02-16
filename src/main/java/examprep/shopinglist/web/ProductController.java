package examprep.shopinglist.web;

import examprep.shopinglist.model.binding.ProductAddBindingModel;
import examprep.shopinglist.model.service.ProductServiceModel;
import examprep.shopinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String getProduct(Model model){
//        if (httpSession.getAttribute("user") == null){      // това е секюрите от поседните валидации във файла
//            return "redirect:/login";                        // това е секюрите от поседните валидации във файла
//        }


        if (!model.containsAttribute("productAddBindingModel")){
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String productAddConfirm(@Valid @ModelAttribute("productAddBindingModel") ProductAddBindingModel productAddBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";

        }
        this.productService.addProduct(this.modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";

    }
    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable String id){

        productService.buyById(id);

        return "redirect:/";
    }

    @GetMapping("buy/all")
    public String buyAll(){
        productService.buyAll();

        return "redirect:/";
    }


}
