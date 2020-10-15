package com.crc.farming.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Article {
    private Integer articleid;
    private String title;
    private Date date;
    private Integer visitnum;
    private String source;
    private String content;
    private Integer id;//专家id（用户表中专家id）
    private String picture;


    public Article() {
    }
    public Article( String title, Date date, String source, String content, Integer id, String picture) {
        this.title = title;
        this.date = date;
        this.source = source;
        this.content = content;
        this.id = id;
        this.picture = picture;
    }

    public Article(Integer articleid, String title, Date date,Integer visitnum, String source, String content, Integer expert_id, String picture) {
        this.articleid = articleid;
        this.title = title;
        this.date = date;
        this.visitnum=visitnum;
        this.source = source;
        this.content = content;
        this.id = id;
        this.picture = picture;
    }


    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(Integer visitnum) {
        this.visitnum = visitnum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", visitnum=" + visitnum +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
