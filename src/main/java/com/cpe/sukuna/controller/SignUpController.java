package com.cpe.sukuna.controller;

import com.cpe.sukuna.entity.User;
import com.cpe.sukuna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/sign-up")
    public ModelAndView signup(ModelAndView modelAndView){
        modelAndView.setViewName("user/sign_up");
        modelAndView.addObject("userAddForm", new UserAddForm());
        return modelAndView;
    }

    @RequestMapping("/add")
    public Object add(@ModelAttribute("userAddForm") @Validated UserAddForm userAddForm,
                      BindingResult bindingResult,
                      RedirectAttributes attributes, ModelAndView modelAndView) throws
            NoSuchAlgorithmException {
        if(bindingResult.hasErrors()) {
            return "user/sign_up";
        }
        userService.createUser(userAddForm);
        attributes.addFlashAttribute("messageDialog", "User was created.");
        return "redirect:/user/login";
    }

    @GetMapping("/calendar")
    public String index(Model model) {
        return "calendar/calen";
    }


}
