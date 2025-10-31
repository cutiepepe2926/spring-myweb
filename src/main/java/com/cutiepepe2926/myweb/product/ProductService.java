package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import org.mybatis.spring.annotation.MapperScan;


public interface ProductService {
    int prodRegist(ProductVO productVO); // 등록
}
