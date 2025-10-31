package com.cutiepepe2926.myweb;

import com.cutiepepe2926.myweb.command.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {
    @Test
    public void test01(){

        // 빌더 패턴
        ProductVO.builder()
                .prodPrice(1000)
                .prodEnddate("2020-12-20")
                .prodWriter("테스트")
                .prodName("상품명")
                .build();
    }
}
