package com.crc.farming.service.Impl;

import com.crc.farming.dao.LeaveMessageDao;
import com.crc.farming.pojo.LeaveMessage;
import com.crc.farming.service.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {
    @Autowired(required =false)
    LeaveMessageDao leaveMessageDao;
    @Override
    public boolean addleavemessage(LeaveMessage leaveMessage) {
        return leaveMessageDao.addleavemessage(leaveMessage);
    }
}
