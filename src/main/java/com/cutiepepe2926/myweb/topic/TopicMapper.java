package com.cutiepepe2926.myweb.topic;

import com.cutiepepe2926.myweb.command.TopicVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
    int topicRegist(TopicVO topicVO); // 게시글 등록
    List<TopicVO> getAllList(); // 전체 게시글 조회
    List<TopicVO> getMyList(String topicWriter); // 내 게시글 조회
    TopicVO getTopic(int topicId); // 특정 게시글 조회
    int  topicUpdate(TopicVO topicVO); // 특정 게시글 수정
    int topicDelete(int topicId); // 특정 게시글 삭제
    TopicVO getTopicDetail(int topicId); // 게시글 내용 조회
}
