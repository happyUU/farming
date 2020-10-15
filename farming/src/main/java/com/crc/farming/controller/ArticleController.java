package com.crc.farming.controller;

import com.crc.farming.pojo.Article;
import com.crc.farming.pojo.Comment;
import com.crc.farming.service.ArticleService;
import com.crc.farming.service.CommentService;
import com.crc.farming.utils.RandomAvatarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/article.html")
    public String queryAllArticle( Model m){
        List<Article> articles=articleService.queryAllArticle();

        for (Article article:articles) {
            java.sql.Date resultDate = new java.sql.Date(article.getDate().getTime());
            article.setDate(resultDate);
            String s=article.getContent();
            String substr = "";
            substr=s.substring(0, 100);
            article.setContent(substr);
        }
        m.addAttribute("articles",articles);
        return "farmer/article";
    }

    @RequestMapping("/article_details")
    public String queryOneArticle(HttpServletRequest request, Model m){
       //根据articleid查文章
        Integer articleid=Integer.parseInt(request.getParameter("id"));
        boolean flag=articleService.updateVisitNum(articleid);
        Article article=articleService.queryOneArticle(articleid);
        java.sql.Date resultDate1 = new java.sql.Date(article.getDate().getTime());
        article.setDate(resultDate1);
        m.addAttribute("article",article);

        //查询所有评论
        List<Comment> comments=commentService.queryAllComment(articleid);
        for (Comment com:comments) {
            //截取名字第一位
            String s=com.getName();
            String substr = "";
            substr=s.substring(0, 1)+"**";
            //日期格式转换
            java.sql.Date resultDate2 = new java.sql.Date(com.getComment_date().getTime());
            com.setComment_date(resultDate2);
            com.setName(substr);
            //随机拿头像地址
            String head_image=RandomAvatarUtils.getAvatar();
            com.setHead_image(head_image);
        }
        m.addAttribute("comments",comments);

        //查询评论数量
        Integer count=commentService.countAllComment(articleid);
        m.addAttribute("count",count);


        return "farmer/article_details";
    }


    @RequestMapping("/addcomment")
    @ResponseBody
    public void addcomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer articleid=Integer.parseInt(request.getParameter("articleid"));
        String message=request.getParameter("message");
        String name=request.getParameter("name");
        /*System.out.println(articleid+message+"=="+name);*/
        Comment comment=new Comment(articleid,message,name,new Date());
        boolean flag=commentService.addcomment(comment);
        response.getWriter().print(flag);

    }



    //根据关键字查询文章
    @RequestMapping("/findArticleByKeyWord")
    public String findArticleByKeyWord(HttpServletRequest request, Model m){
        String keyword=request.getParameter("keyword");
        List<Article> articles=articleService.findArticleByKeyWord(keyword);
        for (Article article:articles) {
            java.sql.Date resultDate = new java.sql.Date(article.getDate().getTime());
            article.setDate(resultDate);
            String s=article.getContent();
            String substr = "";
            substr=s.substring(0, 100);
            article.setContent(substr);
        }
        if (articles!=null&&articles.size()>0){
            m.addAttribute("articles",articles);
            return "farmer/searcharticle";
        }
        else {
            return "redirect:/findNoArticle";
        }

    }

    @RequestMapping("/findNoArticle")
    public String findNoUser(Model m) {
        List<Article> articles=articleService.queryAllArticle();

        for (Article article:articles) {
            java.sql.Date resultDate = new java.sql.Date(article.getDate().getTime());
            article.setDate(resultDate);
            String s=article.getContent();
            String substr = "";
            substr=s.substring(0, 100);
            article.setContent(substr);
        }
        m.addAttribute("result","无此关键字");
        m.addAttribute("articles",articles);
        return "farmer/article";
    }


    //根据访问量或日期排序文章
    @RequestMapping("/sortArticle")
    public String sortArticle(HttpServletRequest request, Model m){
        String sortarticle=request.getParameter("sortarticle");
       /* System.out.println(sortarticle);
        System.out.println(sortarticle.equals("num"));*/
        if (sortarticle.equals("num")){
            List<Article> articles=articleService.sortArticleByNum();
            for (Article article:articles) {
                java.sql.Date resultDate = new java.sql.Date(article.getDate().getTime());
                article.setDate(resultDate);
                String s=article.getContent();
                String substr = "";
                substr=s.substring(0, 100);
                article.setContent(substr);
                m.addAttribute("articles",articles);
            }
        }else if(sortarticle.equals("date")){
            List<Article> articles=articleService.sortArticleByDate();
            for (Article article:articles) {
                java.sql.Date resultDate = new java.sql.Date(article.getDate().getTime());
                article.setDate(resultDate);
                String s=article.getContent();
                String substr = "";
                substr=s.substring(0, 100);
                article.setContent(substr);
                m.addAttribute("articles",articles);
            }
        }

        return "farmer/article";
    }
}
