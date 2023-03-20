package hello.itemservice.domain;

import lombok.Getter;
import lombok.Setter;

// @Data 위험 필요한건 분리해서 사용하는게 좋음
// dto vo 같은 경우는 data
@Getter @Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
