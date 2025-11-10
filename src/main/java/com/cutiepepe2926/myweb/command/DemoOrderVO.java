package com.cutiepepe2926.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoOrderVO {
    private int oId;
    private int mId; //FK
    private String productName;

    // N:1
    //private String name; //가져올 컬럼이 하나인 경우는, 이렇게 추가하는 방법도 가능함
    private DemoMemberVO MemberVO;


}
