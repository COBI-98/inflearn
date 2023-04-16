package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {


    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        //bindingResult.rejectValue("itemName", "required");
//        new FieldError("item","itemName",null,false,messageCodes,null,null);

        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }

    @Test
    void messageCodesResolverField2() {

        String[] messageCodes = codesResolver.resolveMessageCodes("range", "item", "price", Integer.class);

        assertThat(messageCodes).containsExactly(
                "range.item.price",
                "range.price",
                "range.java.lang.Integer",
                "range"
        );
    }
}
