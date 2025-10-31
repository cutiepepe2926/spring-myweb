package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    // 목록화면
    @GetMapping("/productList")
    public void productList(){}

    // 등록화면
    @GetMapping("/productReg")
    public void productReg(){}

    // 상세 화면
    @GetMapping("/productDetail")
    public void productDetail(){}

    // 상품등록
    @PostMapping("/prodRegist")
    public String prodRegist(ProductVO  productVO){
        System.out.println(productVO.toString());
        productService.prodRegist(productVO);
        return "redirect:/product/productList";
    }
    
}
