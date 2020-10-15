package com.crc.farming.service.Impl;

import com.crc.farming.dao.CommentDao;
import com.crc.farming.pojo.Comment;
import com.crc.farming.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required =false)
    CommentDao commentDao;
    @Override
    public List<Comment> queryAllComment(Integer articleid) {
        return commentDao.queryAllComment(articleid);
    }

    @Override
    public Integer countAllComment(Integer articleid) {
        return commentDao.countAllComment(articleid);
    }

    @Override
    public boolean addcomment(Comment comment) {
        return commentDao.addcomment(comment);
    }
}
