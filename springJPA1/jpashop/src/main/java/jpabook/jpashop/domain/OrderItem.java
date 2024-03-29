package jpabook.jpashop.domain;

import static javax.persistence.FetchType.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import jpabook.jpashop.domain.Item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격
    private int count; // 주문 수량

//    protected OrderItem() { // 상품생성 유지보수 @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    }

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem(); // 쿠폰, 할인으로 아이템을 따로 가져가기 위해
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    //==비지니스 로직==//
    public void cancel(){
        getItem().addStock(count);
    }

    //==조회 로직==//

    /**
     * 주문상품 전체가격 조회
     */
    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }

}
