package com.cutiepepe2926.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVO {
    private int categoryId;
    private String groupId;
    private int categoryLv;
    private String categoryNm;
    private int categoryDetailLv;
    private String categoryDetailNm;
    private int categoryParentLv;
    private String categoryDetailParentLv;
}
