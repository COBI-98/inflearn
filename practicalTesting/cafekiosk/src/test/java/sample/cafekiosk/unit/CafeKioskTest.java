package sample.cafekiosk.unit;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;
import sample.cafekiosk.unit.order.Order;

class CafeKioskTest {

    @DisplayName("음료 1개를 추가하면 주문 목록에 담긴다.") // bdd
    @Test
    public void add() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();

        //when
        cafeKiosk.add(new Americano());

        //then
//        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBeverages()).hasSize(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("여러잔 주문")
    @Test
    public void addSeveralBeverages() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        //when
        cafeKiosk.add(americano, 2);

        //then
        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @DisplayName("0잔 주문")
    @Test
    public void addZero() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        //when

        //then
        assertThatThrownBy(() -> cafeKiosk.add(americano,0))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("음료는 1잔 이상 주문하셔야합니다.");
    }

    @DisplayName("삭제")
    @Test
    public void remove() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        //when
        cafeKiosk.remove(americano);

        //then
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    @DisplayName("주문 전체삭제")
    @Test
    public void clear() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();
        cafeKiosk.add(americano);
        cafeKiosk.add(latte);

        //when
        cafeKiosk.clear();

        //then
        assertThat(cafeKiosk.getBeverages()).isEmpty();
    }

    // tdd
    @DisplayName("주문 목록에 담긴 상품들의 총 금액을 계산할 수 있다. ")
    @Test
    void calculateTotalPrice(){
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);

        // 프로덕션 코드보다 테스트 코드를 먼저 작성, 관점의 변화
        int totalPrice = cafeKiosk.calculateTotalPrice();

        assertThat(totalPrice).isEqualTo(8500);
    }

    @DisplayName("주문가능시간 관리")
    @Test
    public void createOrder() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        //when
        Order order = cafeKiosk.createOrder();

        //then
        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("주문가능시간")
    @Test
    public void createOrderWithCurrentTime() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        //when
        Order order = cafeKiosk.createOrder(LocalDateTime.of(2023, 6, 23,10, 0));

        //then
        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("주문불가시간")
    @Test
    public void createOrderOutsideOpenTime() throws Exception{
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano);

        //when

        //then
        assertThatThrownBy(() -> cafeKiosk.createOrder(LocalDateTime.of(2023, 6, 23,9, 59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");
    }

}