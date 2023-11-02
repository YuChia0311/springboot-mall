package com.annlu.springbootmall.controller;

import com.annlu.springbootmall.constant.ProductCategory;
import com.annlu.springbootmall.dto.ProductQueryParams;
import com.annlu.springbootmall.dto.ProductRequest;
import com.annlu.springbootmall.model.Product;
import com.annlu.springbootmall.service.ProductService;
import com.annlu.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")//查詢商品列表
    public ResponseEntity<Page<Product>> getProducts(
            //商品查詢條件
            @RequestParam(required = false) ProductCategory category ,//category是可選的參數 用商品類別查詢
            @RequestParam(required = false) String search,
            //商品排序
            @RequestParam(defaultValue = "created_date") String orderBy,//預設創建時間新到舊排序
            @RequestParam(defaultValue = "desc") String sort,//預設降序排序
            //分頁 參數給預設值 是因為要保護資料庫的效能，不會一次取全部的數據出來
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,//要取得幾筆數據
            @RequestParam(defaultValue = "0") @Min(0) Integer offset //要跳過幾筆數據
            ){
        //將前端傳過來的參數設定到productQueryParams當中
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);
        //取得 product list
        List<Product> productList = productService.getProducts(productQueryParams);
        //取得 product 總數
        Integer total = productService.countProduct(productQueryParams);
        //分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);//將前端傳過來的limit值 返回給前端
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")//根據productId查詢單一商品數據
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if (product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
                                                  //取得前端傳過來的請求參數   //參數不用Product product的原因是 想要直接驗證前端傳過來的請求參數
       Integer productId =  productService.createProduct(productRequest);//返回productId

       Product product = productService.getProductById((productId));//根據productId 從資料庫取得商品數據

       return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")//修改商品
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,//接住url參數
                                                 @RequestBody @Valid ProductRequest productRequest){//接住前端傳過來的參數
        //檢查product是否存在
        Product product = productService.getProductById(productId);

        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品的數據
        productService.updateProduct(productId,productRequest);
                                    //要修改的商品   修改後的值
        Product updateProduct = productService.getProductById(productId);//查詢更新後的商品數據

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    //刪除商品
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
