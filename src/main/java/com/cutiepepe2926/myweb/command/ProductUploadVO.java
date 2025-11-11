package com.cutiepepe2926.myweb.command;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUploadVO {
//    CREATE TABLE PRODUCT_UPLOAD (
//            UPLOAD_NO INT PRIMARY KEY auto_increment,
//            FILENAME varchar(100) not null, ##실제파일명
//    FILEPATH varchar(100) not null, ##폴더명
//    UUID varchar(50) not null, ##UUID명
//    REGDATE TIMESTAMP default now(),
//    PROD_ID INT, ##FK
//    PROD_WRITER VARCHAR(20) ##FK);
    private int uploadNo;
    private String filename;
    private String filepath;
    private String uuid;
    private LocalDateTime regdate;
    private long prodId; //FK
    private String prodWriter; //FK
}
