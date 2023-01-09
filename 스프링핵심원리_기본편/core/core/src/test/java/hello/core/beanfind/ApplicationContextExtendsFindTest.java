package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DisocuntPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.DiscoveryFilter;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestCofing.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 중복 오류가 발생한다")
    void findBeanByParentTypeDuplicate()
    {
       DisocuntPolicy disocuntPolicy = ac.getBean(DisocuntPolicy.class);
       assertThrows(NoUniqueBeanDefinitionException.class,() -> ac.getBean(DisocuntPolicy.class));
    }



    @Configuration
    static class TestCofing{

        @Bean
        public DisocuntPolicy rateDiscountPolicy()
        {
            return new RateDiscountPolicy();
        }
        @Bean
        public DisocuntPolicy fixDiscountPolicy()
        {
            return new FixDiscountPolicy();
        }
    }


}
