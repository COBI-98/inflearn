package lang.immutable.address;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefMain1_2Test {

    @DisplayName("shareReference() : 공유 참조와 사이드 이펙트")
    @Test
    void immutableAddress_shareReference_success() throws Exception{
        //given
        Address a = new Address("서울");
        Address b = a;

        //when
        b.setValue("부산");

        //then
        assertThat(a.toString()).isEqualTo(b.toString());
    }

    @DisplayName("constructor() : 공유 참조와 사이드 이펙트")
    @Test
    void immutableAddress_constructor_success() throws Exception{
        //given
        Address a = new Address("서울");
        Address b = new Address("서울");

        //when
        b.setValue("부산");

        //then
        assertThat(a.toString()).isNotEqualTo(b.toString());
    }
}