package study.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // premetive 타입은 null을 넣지 못하므로 wrapper 타입을 사용한다.
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
