package com.cutiepepe2926.myweb.command;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoMemberVO {
    private int mId;
    private String Name;

    // 1:N조인에서는 LIST 선언
    List<DemoOrderVO> orderList;
}
