package hello.core.discount;

import hello.core.member.Member;

public interface DisocuntPolicy {
    // @Return 할인 대상 금액
    int discount(Member member, int price); // 옵션 + 엔터 누르면 오류 난곳으로 감
}
