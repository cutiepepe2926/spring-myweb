package com.cutiepepe2926.myweb.command;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

}
