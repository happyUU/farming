package com.crc.farming.service;

import com.crc.farming.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> queryAllComment(Integer articleid);
    Integer countAllComment(Integer articleid);
    boolean addcomment(Comment comment);
}
