package com.crc.farming.pojo;

public class Cart {
    private Integer product_id;
    private String product_image;
    private String product_name;
    private String product_classification;
    private Double product_price;
    private Integer product_num;
    private Double product_sumprice;
    private Integer sumnum;
    private Double sumprice;

    public Cart() {
    }

    public Cart(Integer product_id, String product_image, String product_name, String product_classification, Double product_price, Integer product_num) {
        this.product_id = product_id;
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_classification = product_classification;
        this.product_price = product_price;
        this.product_num = product_num;
    }

    public Cart(Integer product_id, String product_image, String product_name, String product_classification, Double product_price, Integer product_num, Double product_sumprice, Integer sumnum, Double sumprice) {
        this.product_id = product_id;
        this.product_image = product_image;
        this.product_name = product_name;
        this.product_classification = product_classification;
        this.product_price = product_price;
        this.product_num = product_num;
        this.product_sumprice = product_sumprice;
        this.sumnum = sumnum;
        this.sumprice = sumprice;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_classification() {
        return product_classification;
    }

    public void setProduct_classification(String product_classification) {
        this.product_classification = product_classification;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Integer product_num) {
        this.product_num = product_num;
    }

    public Double getProduct_sumprice() {
        return product_sumprice;
    }

    public void setProduct_sumprice(Double product_sumprice) {
        this.product_sumprice = product_sumprice;
    }

    public Integer getSumnum() {
        return sumnum;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }

    public Double getSumprice() {
        return sumprice;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product_id=" + product_id +
                ", product_image='" + product_image + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_classification='" + product_classification + '\'' +
                ", product_price=" + product_price +
                ", product_num=" + product_num +
                ", product_sumprice=" + product_sumprice +
                ", sumnum=" + sumnum +
                ", sumprice=" + sumprice +
                '}';
    }
}
