package com.cutiepepe2926.myweb.topic;

import com.cutiepepe2926.myweb.command.TopicVO;
import java.util.List;
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

    @Override
    public List<TopicVO> getAllList() {
        return topicMapper.getAllList();
    }

    @Override
    public List<TopicVO> getMyList(String topicWriter) {
        return topicMapper.getMyList(topicWriter);
    }

    @Override
    public TopicVO getTopic(int topicId) {
        return topicMapper.getTopic(topicId);
    }

    @Override
    public int topicUpdate(TopicVO topicVO) {
        return topicMapper.topicUpdate(topicVO);
    }

    @Override
    public int topicDelete(int topicId) {
        return topicMapper.topicDelete(topicId);
    }

    @Override
    public TopicVO getTopicDetail(int topicId) {
        return topicMapper.getTopicDetail(topicId);
    }
}
