package lang.immutable.address;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberMainV2Test {

    @DisplayName("constructor: 불변 객체 사이드 이펙트 처리")
    @Test
    void memberMainV2_constructor_success() throws Exception{
        //given
        ImmutableAddress address = new ImmutableAddress("서울");
        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        //when
        memberB.setAddress(new ImmutableAddress("부산"));

        //then
        Assertions.assertThat(memberA.getAddress()).isNotEqualTo(memberB.getAddress());
    }
}