package hello.core.order;

import hello.core.discount.DisocuntPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoeymemberRepository;

public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoeymemberRepository();
//  //  private final DisocuntPolicy disocuntPolicy = new RateDiscountPolicy();
//  private DisocuntPolicy disocuntPolicy; // 인터페이스에만 의존함

    private final MemberRepository memberRepository;
    private final DisocuntPolicy disocuntPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DisocuntPolicy disocuntPolicy) {
        this.memberRepository = memberRepository;
        // this.mem 는 위에꺼
        this.disocuntPolicy = disocuntPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

       Member member= memberRepository.findById(memberId);

       int discountPrice = disocuntPolicy.discount(member,itemPrice);


       return new Order(memberId,itemName,itemPrice,discountPrice);

    }

    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
