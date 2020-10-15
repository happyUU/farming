package com.crc.farming.service.Impl;

import com.crc.farming.dao.ArticleDao;
import com.crc.farming.pojo.Article;
import com.crc.farming.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    ArticleDao articleDao;

    @Override
    public List<Article> queryAllArticle() {
        return articleDao.queryAllArticle();
    }

    @Override
    public List<Article> findArticleByKeyWord(String keyword) {
        return articleDao.findArticleByKeyWord(keyword);
    }

    @Override
    public List<Article> sortArticleByNum() {
        return articleDao.sortArticleByNum();
    }

    @Override
    public List<Article> sortArticleByDate() {
        return articleDao.sortArticleByDate();
    }

    @Override
    public Article queryOneArticle(Integer articleid) {
        return articleDao.queryOneArticle(articleid);
    }

    @Override
    public boolean updateVisitNum(Integer articleid) {
        return articleDao.updateVisitNum(articleid);
    }

    @Override
    public boolean addArticle(String title, Date date, String source, String content, Integer id, String picture) {
        return articleDao.addArticle(title,date,source,content,id,picture);
    }

}
