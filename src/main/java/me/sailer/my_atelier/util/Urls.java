package me.sailer.my_atelier.util;

public final class Urls {
    // 테스트용
    public final static String TEST_IAMGE_URL = "https://storage.cloud.google.com/my-atelier-project-images/product-images/node-js.svg";

    // controller urls
    public final static String API = "/api";
    public final static String DETAIL = "_detail";
    public final static String PRODUCT = "product";
    public final static String PRODUCTS = "products";
    public final static String URL_PRODUCTS = "/" + PRODUCTS;
    public final static String API_PRODUCTS = API + URL_PRODUCTS;
    public final static String PRODUCT_DETAIL = PRODUCT + DETAIL;
    public final static String PRODUCT_IMAGES = PRODUCT + "_images";

    public final static String ATELIER = "atelier";
    public final static String URL_ATELIER = "/" + ATELIER;
    public final static String API_ATELIER = API + ATELIER;
    public final static String LOGIN = "login";
    public final static String SEARCH = "search";
    public final static String MY_PAGE= "mypage";

    // mypage 하위 url
    public final static String ORDER = "order";    // mypage/order/{주문번호}
    public final static String CANCEL_EXCHANGE_REFUND = "cancel_exchange_refund";
    public final static String CART = "cart";
    public final static String WISHLIST = "wishlist";
    // end
    public final static String SELLERS = "sellers";
    public final static String MASTER = "master";
    public final static String URL_MASTER = "/" + MASTER;
    public final static String MANAGER = "managers";


    public final static String STATUS = "/status";

    /**
     * 카테고리 번호
     */
    public final static String PARAM_CN = "cn";
}
