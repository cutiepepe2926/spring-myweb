package com.cutiepepe2926.myweb.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVO {
    private int start; //게시판 화면에 보여질 첫페이지 번호
    private int end; //게시판 화면에 보여질 끝페이지 번호
    private boolean prev; //다음 이전 활성화 여부
    private boolean next; //이전버튼 활성화 여부

    private int page; //현재 조회하는 페이지 번호
    private int amount; //한 페이지에서 몇개의 데이터를 보여줄 건가
    private int total; //총 게시물 수

    private int realEnd; //진짜끝번호
    private List<Integer> pageList; //페이지 번호리스트(*타임리프에서는 향상된for문을 쓰기위해 list로 페이지번호생성)

    private Criteria cri; //페이징 기준

    public PageVO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;
        this.page = cri.getPage(); //현재 페이지 가져올 때는 getPage이용해야함
        this.amount = cri.getAmount();

        // 1. 페이지 끝번호 계산
        //this.end = (int)(Math.ceil(this.page / 10.0)  ) * 10;
        // 5번 페이지 조회 -> 끝 페이지내이션 10
        // 15번 페이지 조회 ->  끝 페이지내이션 20
        this.end = (int)Math.ceil( (double)page/10.0 ) * 10;

        // 2. 페이지 시작번호 계산
        this.start = end - 10 + 1;

        this.realEnd = (int)Math.ceil(total / (double)this.amount );

        if(this.end > realEnd ) this.end = realEnd;

        this.prev = this.start > 1;

        this.next = realEnd > this.end;
        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());
    }
}