package com.cutiepepe2926.myweb.util;

import lombok.Data;

@Data

public class Criteria {

    private int page; // 페이지 번호
    private int amount; // 보여줄 데이터 양


    //기본 생성자
    public Criteria() {
        this(1,10);
    }

    // 값 전달받는 생성자
    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    // limit의 함수의 offset 값을 계산하는 getter
    public int pageStart() {
        return (page - 1) * amount;
    }



}
