package com.cpe.sukuna.controller;

import com.cpe.sukuna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("")
public class    LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("user/login");
        modelAndView.addObject("userAddForm", new UserAddForm());
        return modelAndView;
    }

    @RequestMapping("/user/validate")
    public Object add(@PathVariable String s){

        userService.findUser(s);
        return "redirect:/user/home";
    }
    @RequestMapping("/user/home")
    public String home(){

        return "user/home";
    }



    @RequestMapping(value = "/user/failLogin", method = RequestMethod.GET)
    public ModelAndView failLogin(ModelAndView model){
        model.addObject("errorMsg", "Login failed, Invalid name and/or passwod");
        model.addObject("loginFail", true);
        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value = "/user/successLogin", method = RequestMethod.GET)
    public Object successLogin(ModelAndView model, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.setViewName("/user/login");
            return model;
        }
        redirectAttributes.addFlashAttribute("message", "Login Successful");
        model.addObject("loginSuccess", true);
        return "redirect:/";
    }
}
