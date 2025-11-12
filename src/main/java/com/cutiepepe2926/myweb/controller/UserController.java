package com.cutiepepe2926.myweb.controller;

import com.cutiepepe2926.myweb.command.UserVO;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    //화면
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @GetMapping("/userDetail")
    public String userDetail(HttpSession session){
        UserVO user = (UserVO)session.getAttribute("user");
        System.out.println(user);
        if(user == null){
            //로그인 안한 사람
            return "redirect:/user/login";
        }
        //세션 확인
        return "user/userDetail";
    }

    //로그인 요청
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes ra,
                        HttpSession session){
        System.out.println(username+ "," + password);

        UserVO userVO = new UserVO("test","test");
        if (userVO != null){
            session.setAttribute("userVO",userVO);

            return "redirect:/main";
        } else {
            ra.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요.");
            return "redirect:/user/login";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/user/login";
    }

}
