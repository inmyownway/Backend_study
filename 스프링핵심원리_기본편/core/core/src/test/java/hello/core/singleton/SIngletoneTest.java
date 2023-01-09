package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SIngletoneTest {

    @Test
    @DisplayName("스프링 없는 순순한 DI 컨테이너 ")
    void pureContainter()
    {
        AppConfig appConfig = new AppConfig();
        // 1.조회 : 호출할때마다 객체를 생성하는지 확인

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("membeerService1 = "+ memberService1);
        System.out.println("membeerService2 = "+ memberService2);

        // 다른게 생성됨 , 객체가 계속 생성되서 비효율적


        // 1과 2는 다른다  -> 다르니까 테스트 성공
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void spirngContainter()
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1.조회 : 호출할때마다 객체를 생성하는지 확인

        MemberService memberService1 = applicationContext.getBean("memberService",MemberService.class);
        MemberService memberService2 = applicationContext.getBean("memberService",MemberService.class);

        System.out.println("membeerService1 = "+ memberService1);
        System.out.println("membeerService2 = "+ memberService2);

        // 1과 2는 같음  ->  테스트 성공
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
