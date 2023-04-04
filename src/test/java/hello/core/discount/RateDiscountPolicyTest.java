package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인 적용되어야 함")
    void vip_o() {
        Member member = new Member(1L,"memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용안됨")
    void vip_x() {
        Member member = new Member(2L,"memberB", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(0).isEqualTo(discount);
    }
}