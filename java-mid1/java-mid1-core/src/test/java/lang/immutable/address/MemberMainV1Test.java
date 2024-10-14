package lang.immutable.address;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberMainV1Test {

    @DisplayName("constructor() : 불변 객체 사이드 이팩트 예제")
    @Test
    void memberMainV1_constructor_success() throws Exception{
        //given
        Address address = new Address("서울");
        MemberV1 memberV1 = new MemberV1("회원A", address);
        MemberV1 memberV2 = new MemberV1("회원B", address);

        //when
        memberV2.getAddress().setValue("부산");

        //then
        Assertions.assertThat(memberV1.getAddress()).isEqualTo(memberV2.getAddress());
    }
}