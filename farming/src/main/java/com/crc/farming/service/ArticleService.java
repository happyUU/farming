package com.crc.farming.service;

import com.crc.farming.pojo.Article;

import java.util.Date;
import java.util.List;

public interface ArticleService {
    List<Article> queryAllArticle();

    List<Article> findArticleByKeyWord(String keyword);

    List<Article> sortArticleByNum();

    List<Article> sortArticleByDate();

    Article queryOneArticle(Integer articleid);

    boolean updateVisitNum(Integer articleid);

    boolean addArticle(String title, Date date, String source, String content, Integer id, String picture);


}
