package com.cutiepepe2926.myweb.command;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicVO {
    private long topicId;
    private LocalDate topicRegdate;
    private String topicWriter;
    private String topicName;
    private String topicContent;
}
