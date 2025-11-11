package com.cutiepepe2926.myweb.command;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

//@Getter
//@Setter
//@ToString
@Data //getter + setter + toString 한번에 처리해줌!!
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVO {
    private long prodId;
    private LocalDateTime prodRegdate;
    private String prodEnddate;
    private String prodCategory;
    private String prodWriter;
    private String prodName;
    private long prodPrice;
    private long prodCount;
    private long prodDiscount;
    private String prodPurchaseYn;
    private String prodContent;
    private String prodComment;

    //파일객체 선언



    //조인 된 컬럼 결과 - 단순히 가져갈 퀄럼이 1개
    private String categoryNav;

}
