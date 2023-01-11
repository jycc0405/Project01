package com.delivery.project01.Controller;

import com.delivery.project01.DTO.UserDTO;
import com.delivery.project01.Service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private UserLoginService userLoginService;

    public HomeController(UserLoginService u)
    {
        this.userLoginService=u;
    }

    @RequestMapping("/Layout")
    public String question(){return "Layout";}

    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

    @GetMapping("/login")
    public String Login() {
        return "Login";
    }

    @GetMapping("/regi")
    public String showUserList(Model model){
        List<UserDTO> userList = userLoginService.getUserList();
        model.addAttribute("userList",userList);
        return "regi";
    }

    @PostMapping("/regi")
    public String doregi(RedirectAttributes redirect, UserDTO user) {
        if (userLoginService.join(user)) {
            redirect.addAttribute("msg", "회원가입완료");
        }else{
            redirect.addAttribute("msg","중복입니다");
        }
        return "redirect:regicom";
    }

    @RequestMapping(value = "/regicom")
    public String regicom(@RequestParam("msg") String param, Model model)
    {
        model.addAttribute("msg",param);
        return "regicom";
    }
}
