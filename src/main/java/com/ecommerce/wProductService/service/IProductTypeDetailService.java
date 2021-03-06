package com.ecommerce.wProductService.service;

import java.util.List;

import com.ecommerce.wProductService.entity.ProductTypeDetail;


public interface IProductTypeDetailService {

    List<ProductTypeDetail> getProductTypeDetail();
    List<ProductTypeDetail> getProductTypeDetailByProductTypeID(long id);
    void addNewProductTypeDetail(ProductTypeDetail productTypeDetail);
    void updateProductTypeDetail(ProductTypeDetail productTypeDetail);
}
