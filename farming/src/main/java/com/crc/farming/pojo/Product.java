package com.crc.farming.pojo;

public class Product {
    private Integer product_id;
    private String product_name;
    private Double product_price;
    private Integer product_stock;
    private String product_classification;
    private String product_place;
    private String product_description;
    private String product_image;
    private Integer id;

    public Product() {
    }

    public Product(String product_image,String product_name,String product_classification,  Double product_price ) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_classification = product_classification;
        this.product_image = product_image;
    }


    public Product(String product_name, Double product_price, Integer product_stock, String product_classification, String product_place, String product_description, String product_image, Integer id) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_classification = product_classification;
        this.product_place = product_place;
        this.product_description = product_description;
        this.product_image = product_image;
        this.id = id;
    }

    public Product(Integer product_id, String product_name, Double product_price, Integer product_stock,  String product_classification, String product_place, String product_description, String product_image, Integer id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_classification = product_classification;
        this.product_place = product_place;
        this.product_description = product_description;
        this.product_image = product_image;
        this.id=id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(Integer product_stock) {
        this.product_stock = product_stock;
    }

    public String getProduct_classification() {
        return product_classification;
    }

    public void setProduct_classification(String product_classification) {
        this.product_classification = product_classification;
    }

    public String getProduct_place() {
        return product_place;
    }

    public void setProduct_place(String product_place) {
        this.product_place = product_place;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_stock=" + product_stock +
                ", product_classification='" + product_classification + '\'' +
                ", product_place='" + product_place + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_image='" + product_image + '\'' +
                ", id=" + id +
                '}';
    }
}
