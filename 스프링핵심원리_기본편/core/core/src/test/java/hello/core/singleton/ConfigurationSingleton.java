package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.apiguardian.api.API;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleton {

    @Test
    void configurationTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);

        MemberRepository memberRepository3 = ac.getBean("memberRepository",MemberRepository.class);
        MemberRepository memberRepository1 =memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println(memberRepository1+ " "+memberRepository3);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep()
    {        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = "+ bean.getClass());

    }


}
