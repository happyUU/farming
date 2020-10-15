package com.crc.farming.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crc.farming.pojo.User;
import com.crc.farming.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest request, HttpSession session, Model m) throws IOException {
        String name= request.getParameter("name");
        String password=request.getParameter("password");
        User user=userService.logincheck(name,password);
        if (user==null){
            m.addAttribute("error","用户名或密码错误");
        }else {
            session.setAttribute("judge",user);
            return "forward:/article";
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "farmer/register";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpSession session){

        session.removeAttribute("judge");
        return "forward:/article.html";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, Model m){
        System.out.println(user);
        boolean flag=userService.insertUser(user);
        /*System.out.println(flag);*/
        if (flag==true){
            m.addAttribute("result", "注册成功");
        }
        else {
            m.addAttribute("result", "注册失败");
        }
        return "farmer/register";
    }


    @RequestMapping(value = "/updateUserById" ,produces = "application/json; charset=utf-8")
    public void updateUserById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        response.setHeader("content-type","text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name= request.getParameter("name");
        String tel=request.getParameter("tel");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        Integer id=Integer.parseInt(request.getParameter("id"));
       /* System.out.println(id+"=="+name+"=="+tel+"=="+email);*/
        boolean flag=userService.updateUserById(name,tel,email,address,id);
        /*System.out.println(flag);*/
        String json=JSON.toJSONString("修改失败");
        if (flag==true){
           json= JSON.toJSONString("修改成功");
            User user=userService.findUserById(id);
            session.setAttribute("judge",user);
        }
        /*System.out.println(json);*/
        response.getWriter().print(json);
    }


    @RequestMapping(value = "/updateUserPassWordById",produces = "application/json; charset=utf-8")
    public void updateUserPassWordById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        response.setHeader("content-type","text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        String oldpass= request.getParameter("oldpass");
        String password=request.getParameter("newpass");
        Integer id=Integer.parseInt(request.getParameter("id"));
        /*System.out.println(id+"=="+oldpass+"=="+password);*/
        User user=userService.findUserById(id);
        if (user.getPassword().equals(oldpass)){
            boolean flag=userService.updateUserPassWordById(password,id);
            System.out.println(flag);
            String json=JSON.toJSONString("修改失败");
            if (flag==true){
                json= JSON.toJSONString("修改成功");
                User user1=userService.findUserById(id);
                session.setAttribute("judge",user1);

            }
            /*System.out.println(json);*/
            response.getWriter().print(json);

        }else {
            String  json= JSON.toJSONString("旧密码错误");
            response.getWriter().print(json);
        }

    }
}
