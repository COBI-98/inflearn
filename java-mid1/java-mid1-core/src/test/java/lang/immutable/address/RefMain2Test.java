package lang.immutable.address;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefMain2Test {

    @DisplayName("constructor() : 불변객체 - 도입")
    @Test
    void ImmutableAddress_constructor_success() throws Exception{
        //given
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        //when & then
        assertThat(a.toString()).isEqualTo(b.toString());
    }

    @DisplayName("final_constructor() : 불변객체 - 도입")
    @Test
    void ImmutableAddress_constructor_success2() throws Exception{
        //given
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        //when
        b = new ImmutableAddress("부산");

        //
        assertThat(a.toString()).isNotEqualTo(b.toString());
    }
}