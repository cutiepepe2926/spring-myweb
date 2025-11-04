package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.util.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    int prodRegist(ProductVO productVO); // 등록
    //List<ProductVO> getList(String prodWriter); //조회
    
    //파라미터가 2개 이상이면 @Param으로 이름 명시
    List<ProductVO> getList(@Param("prodWriter") String prodWriter,
                             @Param("cri") Criteria cri); // 페이지 별 조회
    int getTotal(@Param("prodWriter") String prodWriter,
                 @Param("cri") Criteria cri); //전체 게시글 수
    ProductVO getDetail(long prodId); // 특정 Id 상세조회
    int prodUpdate(ProductVO productVO); //상품 수정
    int prodDelete(long prodId); // 상품 삭제


}
