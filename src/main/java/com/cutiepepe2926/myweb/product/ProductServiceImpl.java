package com.cutiepepe2926.myweb.product;

import com.cutiepepe2926.myweb.command.CategoryVO;
import com.cutiepepe2926.myweb.command.ProductUploadVO;
import com.cutiepepe2926.myweb.command.ProductVO;
import com.cutiepepe2926.myweb.util.Criteria;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    //파일 업로드 경로
    @Value("${project.upload.path}")
    String uploadPath;

    //폴더 생성 메서드
    public String makeFolder() {
        String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        File file = new File(uploadPath + "/" + path);
        if (!file.exists()) {
            file.mkdirs(); //폴더를 생성
        }
        return path;
    }

    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;

    //메서드를 트랜잭션 처리가 가능함
    //하나의 트랜잭션으로 관리하겠다는 의미
    //단, 한 프로세스 안에서 예외 발생 시, 롤백을 처리
    // 주의점, 에러가 try-catch 되어 있으면 처리 불가! -> DB와 서버 둘 다 적용된다.
    // 안쓰면 오토커밋해제하고 수동 커밋해줘야 함.
    @Transactional(rollbackFor = Exception.class) //예외터지면 롤백시키겠다
    @Override
    public int prodRegist(ProductVO productVO,  List<MultipartFile> files) {

        // 1. productVO -> 상품 insert
        // 2. 업로드
        // 3. productVO의 pk를 fk로 쓰는 upload테이블에 인서트
        // 4. 결과 반환


        // 1.
        int result = productMapper.prodRegist(productVO);

        // 빈 파일 데이터 제거
        // 파일 확장자 검사 -> MultipartFile.getContentType()으로 체크해야 함.
        // 이미지 데이터 처리는 나중에 해줘야 함
        files =  files.stream().
                filter(data -> data.isEmpty() == false)
                .collect(Collectors.toList());
        // 2.
        try {
            for (MultipartFile file : files) {
                // 1. 브라우저 별로 사용자의 경로가 앞에 붙어서 들어오는 경우가 있기 때문에 //기준으로 절삭
                // 2. 동일한 이름으로 올라오는 건 덮어쓰기가 되므로 구분해서 해줘야함
                // 3. 윈도우 시스템의 경우, 폴더 하나에 저장될 수 있는 파일의 갯수가 65536개정도

                String originalFilename = file.getOriginalFilename(); //파일의 이름
                String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\") +1);

                String uuid = UUID.randomUUID().toString(); //랜덤한 16진수 난수 출력
                String filePath = makeFolder();
                String path = uploadPath + "/"+ filePath +"/"+ uuid +"_"+ fileName;
                File saveFile = new File(path);
                file.transferTo(saveFile); //업로드 처리

                // 3.
                int fileResult = productMapper.fileRegist(ProductUploadVO
                        .builder()
                        .filename(fileName)
                        .filepath(path)
                        .uuid(uuid)
                        .prodWriter(productVO.getProdWriter())
                        //.prodId(productVO.getProdId())
                        //prodId를 가져와야함(Mybatis에서 Insert전에 select하는 방법) -> selectKey 사용하면 먼저 값 가져오기가 가능함
                        //MAPPER에서 처리한다는 의미임
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
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

    @Override
    public List<CategoryVO>  getCategoryList() {
        return productMapper.getCategoryList();
    }

    @Override
    public List<CategoryVO> getCategoryChildList(CategoryVO categoryVO) {
        return productMapper.getCategoryChildList(categoryVO);
    }
}
