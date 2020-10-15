package com.crc.farming.controller;

import com.crc.farming.pojo.LeaveMessage;
import com.crc.farming.service.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LeaveMessageController {
    @Autowired
    LeaveMessageService leaveMessageService;

    //留言处理
    @RequestMapping("/addleavemessage")
    @ResponseBody
    public void addleavemessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String message=request.getParameter("message");
        LeaveMessage leaveMessage=new LeaveMessage(name,email,message);
        boolean flag=leaveMessageService.addleavemessage(leaveMessage);
        response.getWriter().print(flag);
    }
}
