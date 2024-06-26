package sample.cafekiosk.spring.domain.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.HOLD;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.STOP_SELLING;
import static sample.cafekiosk.spring.domain.product.ProductType.HANDMADE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import sample.cafekiosk.spring.IntegrationTestSupport;

//@ActiveProfiles("test")
//@SpringBootTest
@Transactional // 문제발생야기 (테스트와 구현의 transactional 주기 확인
//@DataJpaTest 속도가 빠르지만 SpringBootTest 좋음
class ProductRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("판매상태를 확인할수 있는 상품들을 조회한다.")
    @Test
    void findAllBySellingStatusIn() throws Exception {
        //given
        Product product1 = createProduct("001", HANDMADE, SELLING, "아메리카노", 4000);

        Product product2 = createProduct("002", HANDMADE, HOLD, "카페라떼", 4500);

        Product product3 = createProduct("003", HANDMADE, STOP_SELLING, "팥빙수", 7000);
        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        List<Product> products = productRepository.findAllBySellingStatusIn(List.of(SELLING, HOLD));

        //then
        assertThat(products).hasSize(2)
                .extracting("productNumber", "name", "sellingStatus") // extracting : 검증하고싶은 필드만 추출가능
                .containsExactlyInAnyOrder(
                        tuple("001", "아메리카노", SELLING),
                        tuple("002", "카페라떼", HOLD)
                );

    }

    @DisplayName("테스트")
    @Test
    void woowa_test() throws Exception{
        //given


        //when

        //then
    }

    @DisplayName("상품번호 리스트로 상품들을 조회한다.")
    @Test
    void findAllByProductNumbersIn() throws Exception {
        //given
        Product product1 = createProduct("001", HANDMADE, SELLING, "아메리카노", 4000);

        Product product2 = createProduct("002", HANDMADE, HOLD, "카페라떼", 4500);

        Product product3 = createProduct("003", HANDMADE, STOP_SELLING, "팥빙수", 7000);
        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        List<Product> products = productRepository.findAllByProductNumberIn(List.of("001", "002"));

        //then
        assertThat(products).hasSize(2)
                .extracting("productNumber", "name", "sellingStatus") // extracting : 검증하고싶은 필드만 추출가능
                .containsExactlyInAnyOrder(
                        tuple("001", "아메리카노", SELLING),
                        tuple("002", "카페라떼", HOLD)
                );

    }

    @DisplayName("가장 마지막으로 저장한 상품의 상품번호를 읽어온다.")
    @Test
    void findLatestProductNumber() throws Exception {
        String targetProductNumber = "003";
        //given
        Product product1 = createProduct("001", HANDMADE, SELLING, "아메리카노", 4000);

        Product product2 = createProduct("002", HANDMADE, HOLD, "카페라떼", 4500);

        Product product3 = createProduct(targetProductNumber, HANDMADE, STOP_SELLING, "팥빙수", 7000);
        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        String latestProductNumber = productRepository.findLatestProductNumber();

        //then
        assertThat(latestProductNumber).isEqualTo(targetProductNumber);

    }

    @DisplayName("가장 마지막으로 저장한 상품의 상품번호를 읽어올때, 상품이 하나도 없는 경우에는 null을 반환한다.")
    @Test
    void findLatestProductNumberWhenProductIsEmpty() throws Exception {

        //when
        String latestProductNumber = productRepository.findLatestProductNumber();

        //then
        assertThat(latestProductNumber).isNull();

    }

    private Product createProduct(String productNumber, ProductType type, ProductSellingStatus sellingStatus,
                                         String name, int price) {
        return Product.builder()
                .productNumber(productNumber)
                .type(type)
                .sellingStatus(sellingStatus)
                .name(name)
                .price(price)
                .build();
    }
}