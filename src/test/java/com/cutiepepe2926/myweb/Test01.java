package com.cutiepepe2926.myweb;

import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.product.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

//    @Autowired
//    ProductMapper productMapper;
//
//    @Test
//    public void test01(){
//
//
//        // 빌더 패턴
//        ProductVO.builder()
//                .prodPrice(1000)
//                .prodEnddate("2020-12-20")
//                .prodWriter("테스트")
//                .prodName("상품명")
//                .build();
//    }

//    @Test
//    public void 테스트_코드_insert(){
//
//        for (int i=1; i<=100; i++) {
//            ProductVO vo = ProductVO.builder()
//                    .prodName("hello"+i)
//                    .prodWriter("hello")
//                    .prodEnddate("2020-12-20")
//                    .prodPrice(1000*i)
//                    .prodCount(100*i)
//                    .prodDiscount(i)
//                    .prodComment("hello"+i)
//                    .prodContent("hello"+i)
//                    .build();
//
//            productMapper.prodRegist(vo);
//        }
//    }
}
