package hello.core;

import hello.core.discount.DisocuntPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoeymemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application 전체를 설정하고 구성함
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService()
    {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoeymemberRepository();
    }


    @Bean
    public OrderService orderService()
    {
    return new OrderServiceImpl(memberRepository(),disocuntPolicy());
    }

    @Bean
    public DisocuntPolicy disocuntPolicy()
    {
        return new RateDiscountPolicy();
    }

}
