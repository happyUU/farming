package com.crc.farming.controller;

import com.alibaba.fastjson.JSON;
import com.crc.farming.pojo.*;
import com.crc.farming.service.OrderService;
import com.crc.farming.service.ProductService;
import com.crc.farming.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/ok")
    public String test6(){
        return "farmer/ok.html";

    }

    @RequestMapping("/order")
    public String test5(){
        return "farmer/order.html";

    }


    @RequestMapping("product.html")
    public String queryAllProduct(Model m){
        List<Product> products=productService.queryAllProduct();

       /* for (Product product:products) {
            System.out.println(product);
        }*/
        m.addAttribute("products",products);
        return "farmer/listProduct";
    }



    List<Cart> list=new ArrayList<>();
    @RequestMapping("/addcart")
    public String addcart(HttpServletRequest request, HttpSession session,Model m){
        Integer product_num=1;
        Double product_sumprice=0.0;
        Integer sumnum=0;
        Double sumprice=0.0;

        Integer product_id=Integer.parseInt(request.getParameter("product_id"));
        Product product=productService.queryProductById(product_id);

        Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num,product_sumprice,sumnum,sumprice);

        if (!list.isEmpty()){
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
            for (int s=0;s<cartList.size();s++){
                sumnum=sumnum+cartList.get(s).getProduct_num();
                sumprice=sumprice+cartList.get(s).getProduct_sumprice();
            }
            sumnum=sumnum+1;
            sumprice=sumprice+cart.getProduct_price();
           /* System.out.println(sumnum+"===="+sumprice);*/

            for (int x=0;x<cartList.size();x++){

                cartList.get(x).setSumnum(sumnum);
                cartList.get(x).setSumprice(sumprice);

                boolean flag=(cartList.get(x).getProduct_id()).equals(product_id);
                if (flag){
                    cartList.get(x).setProduct_num(cartList.get(x).getProduct_num()+1);
                    cartList.get(x).setProduct_sumprice(cartList.get(x).getProduct_num()*cartList.get(x).getProduct_price());

                    break;
                }else {
                    if (x==cartList.size()-1){
                        Cart cart1=new Cart(product.getProduct_id(),product.getProduct_image(),
                                product.getProduct_name(),product.getProduct_classification(),
                                product.getProduct_price(),product_num,product_sumprice,sumnum,sumprice);
                        cart1.setProduct_sumprice(cart.getProduct_num()*cart.getProduct_price());
                        cartList.add(cart1);

                        break;
                    }
                }

            }
            session.setAttribute("cartList",cartList);
        }
        else {
            cart.setProduct_sumprice(cart.getProduct_num()*cart.getProduct_price());
            cart.setSumnum(cart.getProduct_num());
            cart.setSumprice(cart.getProduct_price());
            list.add(cart);
            session.setAttribute("cartList",list);
        }


        /*List<Cart> cas = (List<Cart>) session.getAttribute("cartList");
        for (Cart ca:cas) {
            System.out.println(ca);
        }*/

        List<Product> products=productService.queryAllProduct();
        m.addAttribute("products",products);
        return "farmer/listProduct";
    }

    @RequestMapping("/tobuy")
    public String tobuy(HttpServletRequest request, HttpSession session,Model m){
        Integer product_num=1;
        Double product_sumprice=0.0;
        Integer sumnum=0;
        Double sumprice=0.0;

        Integer product_id=Integer.parseInt(request.getParameter("product_id"));
        Product product=productService.queryProductById(product_id);
        Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num,product_sumprice,sumnum,sumprice);


        if (!list.isEmpty()){
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
            for (int s=0;s<cartList.size();s++){
                sumnum=sumnum+cartList.get(s).getProduct_num();
                sumprice=sumprice+cartList.get(s).getProduct_sumprice();
            }
            sumnum=sumnum+1;
            sumprice=sumprice+cart.getProduct_price();

            for (int x=0;x<cartList.size();x++){

                cartList.get(x).setSumnum(sumnum);
                cartList.get(x).setSumprice(sumprice);

                boolean flag=(cartList.get(x).getProduct_id()).equals(product_id);
                if (flag){
                    cartList.get(x).setProduct_num(cartList.get(x).getProduct_num()+1);
                    cartList.get(x).setProduct_sumprice(cartList.get(x).getProduct_num()*cartList.get(x).getProduct_price());

                    break;
                }else {
                    if (x==cartList.size()-1){
                        Cart cart1=new Cart(product.getProduct_id(),product.getProduct_image(),
                                product.getProduct_name(),product.getProduct_classification(),
                                product.getProduct_price(),product_num,product_sumprice,sumnum,sumprice);
                        cart1.setProduct_sumprice(cart.getProduct_num()*cart.getProduct_price());
                        cartList.add(cart1);

                        break;
                    }
                }

            }
            session.setAttribute("cartList",cartList);
        }
        else {
            cart.setProduct_sumprice(cart.getProduct_num()*cart.getProduct_price());
            cart.setSumnum(cart.getProduct_num());
            cart.setSumprice(cart.getProduct_price());
            list.add(cart);
            session.setAttribute("cartList",list);
        }

        return "farmer/cart";
    }



    @RequestMapping(value = "/jiesuan",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String jiesuan(@RequestParam("carts") String map,HttpSession session){
        Integer sumnum=0;
        Double sumprice=0.0;
        Double product_sumprice=0.0;
        List<Cart> cartjs=new ArrayList<>();

        ObjectMapper MAPPER = new ObjectMapper();
        try {
            HashMap<String,String> hashMap = MAPPER.readValue(map, HashMap.class);

            for(Map.Entry<String,String> entry: hashMap.entrySet()){
                Integer product_id=Integer.parseInt(entry.getKey());
                Integer product_num=Integer.parseInt(entry.getValue());
                Product product=productService.queryProductById(product_id);
                sumnum=sumnum+product_num;
                sumprice=sumprice+product.getProduct_price()*product_num;
            }
            for(Map.Entry<String,String> entry: hashMap.entrySet()){
                Integer product_id=Integer.parseInt(entry.getKey());
                Integer product_num=Integer.parseInt(entry.getValue());
                Product product=productService.queryProductById(product_id);
                 product_sumprice=product.getProduct_price()*product_num;
                Cart cart=new Cart(product.getProduct_id(),product.getProduct_image(),product.getProduct_name(),product.getProduct_classification(),product.getProduct_price(),product_num,product_sumprice,sumnum,sumprice);
                cartjs.add(cart);
            }
            session.setAttribute("cartjs",cartjs);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

      /*  List<Cart> cas = (List<Cart>) session.getAttribute("cartjs");
        for (Cart ca:cas) {
            System.out.println(ca);
        }*/
        String json= JSON.toJSONString("提交成功");
        return json;
    }




    @RequestMapping(value = "/zhifu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String zhifu(@RequestParam("orders") String map,HttpServletRequest request,HttpSession session){

        Integer id = Integer.parseInt(request.getParameter("id"));
        /*System.out.println("id:"+id);*/
        Ord ord =new Ord();
        boolean flag=true;
        int rs =0;
        while (flag==true){
            String s1="10086";
            String s2 = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5 - 1)));
            rs=Integer.parseInt(s1+s2);

            ord = orderService.findOrderId(rs);
            /*System.out.println(ord);*/
            if (ord==null){
                flag=false;
                break;

            }else if (ord.getId()!=null){
                flag=true;
            }
        }

        /*System.out.println("flag:"+flag);*/
        Ord ord1=new Ord(rs,id,new Date());
        boolean result1=orderService.insertorder(ord1);
        /*System.out.println("result1"+result1);*/

        ObjectMapper MAPPER = new ObjectMapper();
        try {
            HashMap<String,String> hashMap = MAPPER.readValue(map, HashMap.class);

            for(Map.Entry<String,String> entry: hashMap.entrySet()){
                Integer product_id=Integer.parseInt(entry.getKey());
                Integer product_num=Integer.parseInt(entry.getValue());

                if (result1==true){
                    Ordpro ordpro=new Ordpro(ord1.getOrderid(),product_id,product_num);
                    boolean result2=orderService.insertorder_product(ordpro);
                   /* System.out.println("result2"+result2);*/
                }
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        String json= JSON.toJSONString("提交成功");
        return json;
    }





}
