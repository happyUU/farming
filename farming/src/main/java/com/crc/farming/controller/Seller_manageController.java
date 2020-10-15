package com.crc.farming.controller;

import com.crc.farming.pojo.*;
import com.crc.farming.service.OrderService;
import com.crc.farming.service.ProductService;
import com.crc.farming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/seller_manage")
public class Seller_manageController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;


    @RequestMapping("/index.html")
    public String test1(){
        return "seller_manage/index";
    }
    @RequestMapping("/insert.html")
    public String test2(){
        return "seller_manage/insert";
    }
    @RequestMapping("/system.html")
    public String test5(){
        return "seller_manage/system";
    }


    @RequestMapping("/uploadproduct")
    public String fileUpload(@RequestParam("file") MultipartFile file , HttpServletRequest request) throws IOException {
        String product_name=request.getParameter("product_name");
        Double product_price =Double.parseDouble(request.getParameter("product_price")) ;
        Integer product_stock =Integer.parseInt(request.getParameter("product_stock")) ;
        String product_classification =request.getParameter("product_classification") ;
        String product_place = request.getParameter("product_place");
        String product_description = request.getParameter("product_description");

        Integer id=Integer.parseInt(request.getParameter("id"));


       /* System.out.println(product_name+"="+product_price+"="+product_stock+"="+product_classification);
        System.out.println(product_place+"="+product_description+"="+id);
*/
         String picturesource="articleimage/";

        String uploadFileName = file.getOriginalFilename();
        /*  System.out.println(uploadFileName);*/
        String product_image=picturesource+uploadFileName;
        /* System.out.println("图片路径 : "+product_image);*/
        InputStream is = file.getInputStream(); //文件输入流
        String realPath="src/main/resources/static/farmer/images/articleimage";
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流
        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();

        Product product=new Product(product_name,product_price, product_stock, product_classification,product_place,product_description,product_image,id);
        boolean b = productService.addProduct(product);
        /*System.out.println(b);*/

        return "redirect:/product.html";
    }



    @RequestMapping("/nomyorderq")
    public String test6(){
        return "seller_manage/nomyorderq";
    }


    @RequestMapping("/myorderq")
    public String test7(HttpServletRequest request, HttpSession session){
        Integer id=Integer.parseInt(request.getParameter("id"));
        /*System.out.println(id);*/
        String name = userService.findUserById(id).getName();


        List<Ord> ordlist=orderService.findUserOrder(id);
        /*System.out.println(ordlist.isEmpty());*/
        if(ordlist.isEmpty()){
            return "seller_manage/nomyorderq";
        }else {
            List<Order> orderList=new ArrayList<>();

            for (Ord ord:ordlist) {
                Double sumprice=0.0;
                List<Cart> carts =new ArrayList<>();
                List<Ordpro> ordprolist=orderService.findUserOrderProduct(ord.getOrderid());
                java.sql.Date resultDate = new java.sql.Date(ord.getOrdertime().getTime());
                ord.setOrdertime(resultDate);
                for (Ordpro ordpro:ordprolist) {
                    Integer product_num=ordpro.getProduct_num();
                    Double product_price = productService.queryProductById(ordpro.getProduct_id()).getProduct_price();
                    sumprice=sumprice+product_price*product_num;

                    Product product=productService.queryProductById(ordpro.getProduct_id());
                    Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num);
                    carts.add(cart);

                }


                Order order=new Order(name,ord.getOrderid(),ord.getOrdertime(),carts,sumprice);

                orderList.add(order);

                session.setAttribute("orderList",orderList);

            }

      /*  List<Order> orders = (List<Order>) session.getAttribute("orderList");
        for (Order order:orders){
            java.sql.Date resultDate = new java.sql.Date(order.getOrdertime().getTime());
            order.setOrdertime(resultDate);
            System.out.println(order.getOrderid()+"--"+order.getName()+"--"+order.getOrdertime()+"--"+order.getSumprice());
            for (Cart ca:order.getCarts()){
                System.out.println(ca.getProduct_id()+"--"+ca.getProduct_image()+"--"+ca.getProduct_name()+"--"+ca.getProduct_classification()+"--"+ca.getProduct_price()+"--"+ca.getProduct_num());

            }System.out.println("================================");
        }*/



            return "seller_manage/myorderq";
        }


    }


    //根据模糊id查询文章
    @RequestMapping("/findOrderByLikeId")
    public String findOrderByIdName(HttpServletRequest request,HttpSession session, Model m){
        String productornum=request.getParameter("productornum");
        Integer id=Integer.parseInt(request.getParameter("id"));

        boolean numeric = isNumeric(productornum);

        if (numeric==true){
            Integer orderid=Integer.parseInt(productornum);
            /* System.out.println(orderid+"--"+id);*/
            List<Ord> ordList = orderService.findOrderByLikeId(orderid,id);
            if (ordList.isEmpty()){
                String name = userService.findUserById(id).getName();
                List<Ord> ordlist=orderService.findUserOrder(id);
                List<Order> orderList=new ArrayList<>();
                for (Ord ord:ordlist) {
                    Double sumprice=0.0;
                    List<Cart> carts =new ArrayList<>();
                    List<Ordpro> ordprolist=orderService.findUserOrderProduct(ord.getOrderid());
                    java.sql.Date resultDate = new java.sql.Date(ord.getOrdertime().getTime());
                    ord.setOrdertime(resultDate);
                    for (Ordpro ordpro:ordprolist) {
                        Integer product_num=ordpro.getProduct_num();
                        Double product_price = productService.queryProductById(ordpro.getProduct_id()).getProduct_price();
                        sumprice=sumprice+product_price*product_num;

                        Product product=productService.queryProductById(ordpro.getProduct_id());
                        Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num);
                        carts.add(cart);
                    }
                    Order order=new Order(name,ord.getOrderid(),ord.getOrdertime(),carts,sumprice);
                    orderList.add(order);
                    session.setAttribute("orderList",orderList);
                }
                m.addAttribute("result","无此订单");
                return "seller_manage/myorderq.html";
            }
            else {
                String name = userService.findUserById(id).getName();
                List<Order> orderList=new ArrayList<>();
                for (Ord ord:ordList) {
                    Double sumprice=0.0;
                    List<Cart> carts =new ArrayList<>();
                    List<Ordpro> ordprolist=orderService.findUserOrderProduct(ord.getOrderid());
                    java.sql.Date resultDate = new java.sql.Date(ord.getOrdertime().getTime());
                    ord.setOrdertime(resultDate);
                    for (Ordpro ordpro:ordprolist) {
                        Integer product_num=ordpro.getProduct_num();
                        Double product_price = productService.queryProductById(ordpro.getProduct_id()).getProduct_price();
                        sumprice=sumprice+product_price*product_num;

                        Product product=productService.queryProductById(ordpro.getProduct_id());
                        Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num);
                        carts.add(cart);
                    }
                    Order order=new Order(name,ord.getOrderid(),ord.getOrdertime(),carts,sumprice);
                    orderList.add(order);
                    session.setAttribute("orderList",orderList);
                }
                return "seller_manage/searchmyorderq.html";
            }


        }
        else {
            String name = userService.findUserById(id).getName();
            List<Ord> ordlist=orderService.findUserOrder(id);
            List<Order> orderList=new ArrayList<>();
            for (Ord ord:ordlist) {
                Double sumprice=0.0;
                List<Cart> carts =new ArrayList<>();
                List<Ordpro> ordprolist=orderService.findUserOrderProduct(ord.getOrderid());
                java.sql.Date resultDate = new java.sql.Date(ord.getOrdertime().getTime());
                ord.setOrdertime(resultDate);
                for (Ordpro ordpro:ordprolist) {
                    Integer product_num=ordpro.getProduct_num();
                    Double product_price = productService.queryProductById(ordpro.getProduct_id()).getProduct_price();
                    sumprice=sumprice+product_price*product_num;

                    Product product=productService.queryProductById(ordpro.getProduct_id());
                    Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num);
                    carts.add(cart);
                }
                Order order=new Order(name,ord.getOrderid(),ord.getOrdertime(),carts,sumprice);
                orderList.add(order);
                session.setAttribute("orderList",orderList);
            }
            m.addAttribute("result","无此订单");
            return "seller_manage/myorderq.html";
        }

    }






    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }return true;
    }


}