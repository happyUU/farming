package com.crc.farming.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Comment {
    private String head_image;
    private Integer articleid;
    private String comment;
    private String name;
    private Date comment_date;
    public Comment() {
    }

    public Comment(Integer articleid, String comment, String name, Date comment_date) {
        this.articleid = articleid;
        this.comment = comment;
        this.name = name;
        this.comment_date = comment_date;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "articleid=" + articleid +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                ", comment_date=" + comment_date +
                '}';
    }
}
