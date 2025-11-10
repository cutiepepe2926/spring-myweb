package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.CategoryVO;
import com.cutiepepe2926.myweb.product.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    // 대분류 카테고리 조회
    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryVO>> getCategory(){
        List<CategoryVO> category = productService.getCategoryList();

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // 중~소분류 카테고리 조회
    @GetMapping("/getCategoryChild/{groupId}/{categoryLv}/{categoryDetailLv}")
    public ResponseEntity<List<CategoryVO>> getCategoryChild(@PathVariable("groupId") String groupId,
                                                             @PathVariable("categoryLv") int categoryLv,
                                                             @PathVariable("categoryDetailLv") int categoryDetailLv){
        CategoryVO categoryVO =
        CategoryVO.builder()
                .groupId(groupId)
                .categoryLv(categoryLv)
                .categoryDetailLv(categoryDetailLv)
                .build();

        List<CategoryVO> category = productService.getCategoryChildList(categoryVO);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


}
