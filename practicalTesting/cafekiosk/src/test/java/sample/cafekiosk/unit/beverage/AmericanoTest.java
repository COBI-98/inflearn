package sample.cafekiosk.unit.beverage;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmericanoTest {

    @DisplayName("이름")
    @Test
    public void getName() throws Exception{
        //given
        Americano americano = new Americano();

        //when

        //then
//        assertEquals(americano.getName(), "아메리카노");
        assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @DisplayName("가격")
    @Test
    public void getPrice() throws Exception{
        //given
        Americano americano = new Americano();

        //when

        //then
        assertThat(americano.getPrice()).isEqualTo(4000);
    }
}