package com.crc.farming.dao;

import com.crc.farming.pojo.LeaveMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveMessageDao {
    boolean addleavemessage(LeaveMessage leaveMessage);
}
