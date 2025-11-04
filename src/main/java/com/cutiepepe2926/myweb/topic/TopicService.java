package com.cutiepepe2926.myweb.topic;

import com.cutiepepe2926.myweb.command.TopicVO;
import com.cutiepepe2926.myweb.util.Criteria;
import java.util.List;
import javax.swing.ListModel;
import org.apache.ibatis.annotations.Param;

public interface TopicService {
    int topicRegist(TopicVO topicVO); // 게시글 등록
    //List<TopicVO> getAllList(); // 전체 게시글 조회
    List<TopicVO> getAllList(@Param("prodWriter") String topicWriter,
                             @Param("cri") Criteria cri); //전체 게시글 제한 조회
    int getAllTotal(@Param("prodWriter") String topicWriter,
                    @Param("cri") Criteria cri); //전체 게시글 수

    List<TopicVO> getMyList(@Param("topicWriter") String topicWriter,
                            @Param("cri") Criteria cri); // 내 게시글 제한 조회
    int getMyTotal(@Param("topicWriter") String prodWriter); // 내 게시글 수

    TopicVO getTopic(int topicId); // 특정 게시글 조회
    int  topicUpdate(TopicVO topicVO); // 특정 게시글 수정
    int topicDelete(int topicId); // 특정 게시글 삭제
    TopicVO getTopicDetail(int topicId); // 게시글 내용 조회
}
