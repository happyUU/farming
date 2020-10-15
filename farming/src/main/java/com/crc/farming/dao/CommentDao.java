package com.crc.farming.dao;

import com.crc.farming.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    List<Comment> queryAllComment(Integer articleid);
    Integer countAllComment(Integer articleid);
    boolean addcomment(Comment comment);
}
