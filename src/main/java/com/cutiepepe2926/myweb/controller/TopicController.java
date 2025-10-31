package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.TopicVO;
import com.cutiepepe2926.myweb.topic.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicController {
    private final TopicServiceImpl topicService;

    public TopicController(TopicServiceImpl topicService) {
        this.topicService = topicService;
    }
    //서비스오토와이어

    // 상세화면
    @GetMapping("/topicDetail")
    public void  topicDetail(){
    }

    // 모든 토픽 리스트 화면
    @GetMapping("/topicListAll")
    public void topicListAll(){}

    // 내 토픽 리스트 화면
    @GetMapping("/topicListMe")
    public void topicListMe(){}

    // 토픽 수정 화면
    @GetMapping("/topicModify")
    public void topicModify(){}

    // 토픽 등록 화면
    @GetMapping("/topicReg")
    public void topicReg(){}

    // 토픽 등록
    @PostMapping("/topicRegist")
    public String topicRegist(TopicVO topicVO) {
        System.out.println(topicVO.toString());
        topicService.topicRegist(topicVO);
        return "redirect:/topic/topicListAll";
    }
}
