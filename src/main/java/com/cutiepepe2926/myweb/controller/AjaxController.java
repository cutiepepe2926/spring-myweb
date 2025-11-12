package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.CategoryVO;
import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.product.ProductService;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @Value("${project.upload.path}")
    private String uploadPath;

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

    // 파일 이미지 처리
    // 2가지 방법이 존재. ? 쿼리스트링으로 처리할건지, 쿼리파라미터로 처리할지(pathvariable)
    @GetMapping("/display/{filepath}/{uuid}/{filename}")
    public ResponseEntity<byte[]> dispaly(@PathVariable("filepath") String filepath,
                                          @PathVariable("uuid") String uuid,
                                          @PathVariable("filename") String filename){



        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;

        System.out.println(path);

        File file = new File(path);

        // 헤더 객체 (컨텐츠 타입)
        HttpHeaders headers = new HttpHeaders();


        //파일의 바이트데이터 구해오기

        byte[] bytes = null;

        try {
            bytes =  FileCopyUtils.copyToByteArray(file);
            headers.add("Content-Type", Files.probeContentType(file.toPath()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(bytes, headers,HttpStatus.OK);
    }



}
