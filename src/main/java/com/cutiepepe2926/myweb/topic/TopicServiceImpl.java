package com.cutiepepe2926.myweb.topic;

import com.cutiepepe2926.myweb.command.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    @Qualifier("topicMapper")
    private TopicMapper topicMapper;

    @Override
    public int topicRegist(TopicVO topicVO) {
        return topicMapper.topicRegist(topicVO);
    }

}
