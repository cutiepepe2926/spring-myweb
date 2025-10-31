package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int prodRegist(ProductVO productVO); // 등록
}
