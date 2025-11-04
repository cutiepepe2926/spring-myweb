package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.util.Criteria;
import java.util.List;
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

//    @Override
//    public List<ProductVO> getList(String prodWriter) {
//        return productMapper.getList(prodWriter);
//    }
    @Override
    public List<ProductVO> getList(String prodWriter, Criteria cri) {
        return productMapper.getList(prodWriter, cri);
    }

    @Override
    public ProductVO getDetail(long prodId) {
        return productMapper.getDetail(prodId);
    }

    @Override
    public int prodUpdate(ProductVO productVO) {
        return productMapper.prodUpdate(productVO);
    }

    @Override
    public int getTotal(String prodWriter, Criteria cri) {
        return productMapper.getTotal(prodWriter, cri);
    }

    @Override
    public int prodDelete(long prodId) {
        return productMapper.prodDelete(prodId);
    }
}
