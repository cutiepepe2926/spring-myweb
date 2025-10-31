package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;

    @Override
    public int prodRegist(ProductVO productVO) {
        return productMapper.prodRegist(productVO);
    }
}
