package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.TopicVO;
import com.cutiepepe2926.myweb.topic.TopicServiceImpl;
import com.cutiepepe2926.myweb.util.Criteria;
import com.cutiepepe2926.myweb.util.PageVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    @Qualifier("topicService")
    private TopicServiceImpl topicService;

    // 상세화면
    @GetMapping("/topicDetail")
    public String topicDetail(@RequestParam("topicId") int topicId,
                             Model model){
        TopicVO vo = topicService.getTopicDetail(topicId);
        System.out.println(vo);
        model.addAttribute("vo",vo);
        return "topic/topicDetail";
    }

    // 모든 토픽 리스트 화면
    @GetMapping("/topicListAll")
    public String topicListAll(@ModelAttribute("criteria") Criteria criteria, Model model){
        String topicWriter = criteria.getSearchWriter();
        List<TopicVO> topicList = topicService.getAllList(topicWriter, criteria);
        int total = topicService.getAllTotal(topicWriter, criteria); //전체 게시글 수
        PageVO pageVO = new PageVO(criteria, total);
        model.addAttribute("topicList",topicList);
        model.addAttribute("pageVO",pageVO);
        return "topic/topicListAll";
    }

    // 내 토픽 리스트 화면
    @GetMapping("/topicListMe")
    public String topicListMe(Criteria criteria, Model model){
        String topicWriter = "cutiepepe";
        List<TopicVO> topicList = topicService.getMyList(topicWriter, criteria);
        int total = topicService.getMyTotal(topicWriter);
        PageVO pageVO = new PageVO(criteria, total);

        model.addAttribute("topicList",topicList);
        model.addAttribute("pageVO",pageVO);

        return "topic/topicListMe";
    }

    // 토픽 수정 화면
    @GetMapping("/topicModify")
    public String topicModify(@RequestParam("topicId") int topicId,
                            Model model){
        TopicVO vo = topicService.getTopic(topicId);
        System.out.println(vo);
        model.addAttribute("vo",vo);
        return "topic/topicModify";
    }

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

    // 토픽 수정
    @PostMapping("/topicUpdate")
    public String topicUpdate(TopicVO topicVO) {
        System.out.println(topicVO.toString());

        int result = topicService.topicUpdate(topicVO); //성공 시 1, 실패 시 0
        if (result == 1) {
            System.out.println("수정 성공");
            return "redirect:/topic/topicModify?topicId=" + topicVO.getTopicId(); // 수정 이후에 다시 상세화면으로
        }
        else {
            System.out.println("수정 실패");
            return "redirect:/topic/topicListAll";
        }
    }


    // 토픽 삭제
    @PostMapping("/topicDelete")
    public String topicDelete(@RequestParam("topicId") int topicId,
                              RedirectAttributes re) {
        int result = topicService.topicDelete(topicId);
        if (result == 1) {
            System.out.println("삭제 성공");
            re.addFlashAttribute("msg","삭제 성공");
            return "redirect:/topic/topicListAll";
        }
        else  {
            System.out.println("삭제 실패");
            re.addFlashAttribute("msg","삭제 실패");
            return "redirect:/topic/topicListAll";
        }
    }
}
