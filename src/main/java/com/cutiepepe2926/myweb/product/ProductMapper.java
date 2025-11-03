package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int prodRegist(ProductVO productVO); // 등록
    List<ProductVO> getList(String prodWriter); //조회
    ProductVO getDetail(long prodId); // 특정 Id 상세조회
    int prodUpdate(ProductVO productVO); //상품 수정
    int prodDelete(long prodId); // 상품 삭제


}
