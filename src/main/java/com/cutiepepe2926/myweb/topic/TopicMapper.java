package com.cutiepepe2926.myweb.topic;

import com.cutiepepe2926.myweb.command.TopicVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
    int topicRegist(TopicVO topicVO);
}
