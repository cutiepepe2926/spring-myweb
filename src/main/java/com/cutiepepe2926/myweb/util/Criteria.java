package com.cutiepepe2926.myweb.util;

import lombok.Data;

@Data

public class Criteria {

    private int page; // 페이지 번호
    private int amount; // 보여줄 데이터 양

    // 검색에 사용할 키워드 추가
    private String searchName;
    private String searchContent;
    private String searchWriter;
    private String searchPrice;
    private String startDate;
    private String endDate;

    //기본 생성자
    public Criteria() {
        this(1,10);
    }

    // 값 전달받는 생성자
    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    // limit의 함수의 offset 값을 계산하는 getter -> DB용함수임
    public int getPageStart() {
        return (page - 1) * amount;
    }
}
