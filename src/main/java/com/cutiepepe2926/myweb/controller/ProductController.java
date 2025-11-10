package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.product.ProductService;
import com.cutiepepe2926.myweb.util.Criteria;
import com.cutiepepe2926.myweb.util.PageVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    // 목록화면
    @GetMapping("/productList")
    public String productList(@ModelAttribute("criteria") Criteria criteria, Model model){
        String prodWriter = "ㅂㅈㄷㄱ";
        //List<ProductVO> prodList = productService.getList(prodWriter);
        List<ProductVO> prodList = productService.getList(prodWriter,criteria);
        int total =  productService.getTotal(prodWriter, criteria); // 전체 게시글 수
        PageVO pageVO = new PageVO(criteria, total);
        System.out.println(pageVO);
        System.out.println(prodList.toString());
        
        model.addAttribute("prodList",prodList); // 해당 페이지 게시글 리스트
        model.addAttribute("pageVO",pageVO); // 페이지 정보
        return "product/productList";
    }



    // 등록화면
    @GetMapping("/productReg")
    public void productReg(){}

    // 상세 화면
    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") long prodId,
                              Model model){
        ProductVO vo = productService.getDetail(prodId);
        System.out.println(vo);
        model.addAttribute("vo",vo);
        return "product/productDetail";
    }

    // 상품등록
    @PostMapping("/prodRegist")
    public String prodRegist(ProductVO  productVO){
        System.out.println(productVO.toString());
        productService.prodRegist(productVO);

        return "redirect:/product/productList";
    }

    // 상품 수정
    @PostMapping("/productUpdate")
    public String productUpdate(ProductVO productVO) {
        System.out.println(productVO.toString());

        int result = productService.prodUpdate(productVO); //성공 시 1, 실패 시 0
        if (result == 1) {
            System.out.println("수정 성공");
            return "redirect:/product/productDetail?prodId=" + productVO.getProdId(); // 수정 이후에 다시 상세화면으로
        }
        else {
            System.out.println("수정 실패");
            return "redirect:/product/productList";
        }
    }

    // 상품 삭제
    @PostMapping("/productDelete")
    public String productDelete(@RequestParam("prodId") long prodId,
                                RedirectAttributes re) {
        int result = productService.prodDelete(prodId);
        if (result == 1) {
            System.out.println("삭제 성공");
            re.addFlashAttribute("msg","삭제 성공");
            return "redirect:/product/productList";
        }
        else  {
            System.out.println("삭제 실패");
            re.addFlashAttribute("msg","삭제 실패");
            return "redirect:/product/productList";
        }

    }
}
