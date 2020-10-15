package com.crc;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.crc.farming.pojo.*;
import com.crc.farming.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class FarmingApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    LeaveMessageService leaveMessageService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    @Test
    void contextLoads() {
       /* User user=new User(100,"cc","123456","123456",0);
        System.out.println(userService.insertUser(user));*/
      /*  userService.updateUserById("aaaaaa","18702654203","123@outlook.com",4);*/
        /*System.out.println(userService.findUserById(1));*/
       /* System.out.println(userService.updateUserPassWordById("123456",2));*/

       /*String name="张三";
       String password="123456";
       User user=userService.logincheck(name, password);
       System.out.println(user);*/

     /* List<Article> list=articleService.queryAllArticle();
        for (Article article:list) {
            System.out.println(article);

        }*/
      /*List<Article> list=articleService.findArticleByKeyWord("大棚");
        for (Article article:list) {
            System.out.println(article.getArticleid());

        }*/
        /*List<Article> list=articleService.sortArticleByDate();
        for (Article article:list) {
            System.out.println(article.getArticleid());

        }*/
        /*System.out.println(articleService.updateVisitNum(1));*/

       /*List<Comment> list=commentService.queryAllComment(1);
        for (Comment com:list) {
            java.sql.Date resultDate = new java.sql.Date(com.getComment_date().getTime());
            com.setComment_date(resultDate);
            System.out.println(com);
        }*/
        /*System.out.println(commentService.countAllComment(1));*/
        /*Comment comment=new Comment(1,"真的有效","刘女士",new Date());
        commentService.addcomment(comment);
*/
        /*LeaveMessage leaveMessage=new LeaveMessage("李四","123@qq.com","很实用，感谢");
        System.out.println(leaveMessageService.addleavemessage(leaveMessage));*/

       /* articleService.addArticle("title",new Date(),"source","content",12,"picture");*/


       /* List<Product> lists=productService.queryAllProduct();
        for (Product product:lists) {
            System.out.println(product);
        }*/

      /*  System.out.println(productService.queryProductById(2));*/

//        Ord ord=new Ord(1008615231,4,new Date());
//        orderService.insertorder(ord);
       /* Ord ord=orderService.findOrderId(100865210);
        if (ord!=null){
            System.out.println("aaaa");
        }else {
            System.out.println("bbb");
        }*/


      /*  Ordpro ordpro=new Ordpro(1008616813,3,2);
        System.out.println(orderService.insertorder_product(ordpro));*/
        /*List<Ord> list=orderService.findUserOrder(1);
        for (Ord ord:list) {
            System.out.println(ord);
        }*/

     /*   List<Ordpro> list1=orderService.findUserOrderProduct(1008642340);
        for (Ordpro ordpro:list1) {
            System.out.println(ordpro);
        }*/

        List<Ord> ordList = orderService.findOrderByLikeId(10086,1);
        for (Ord ord:ordList) {
            System.out.println(ord);
        }

    }

}
