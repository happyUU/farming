package com.crc.farming.controller;

import com.crc.farming.pojo.Comment;
import com.crc.farming.pojo.LeaveMessage;
import com.crc.farming.service.ArticleService;
import com.crc.farming.service.CommentService;
import com.crc.farming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class FarmerController {

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/article")
    public String test1(){

        return "forward:/article.html";

    }
    @RequestMapping("/contact")
    public String test2(){

        return "farmer/contact";

    }


    @RequestMapping("/product")
    public String test3(){

        return "forward:/product.html";

    }

    @RequestMapping("/cart")
    public String test4(){

        return "farmer/cart.html";

    }


}
