package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.MymportBeanDefinitionRegistrar;
import org.springframework.context.annotation.*;

//@Conditional(WindowsCondition.class)
@Configuration
@Import({Red.class, Color.class,MyImportSelector.class, MymportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /**
     *  * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "person")
    public Person person() {
        System.out.println("给容器中添加Person");
        return new Person("zs", 25);
    }


    @Bean(value = "bill")
    public Person person01() {
        return new Person("bill", 62);
    }
    @Conditional({LinuxCondition.class})
    @Bean(value = "linus")
    public Person person02() {
        return new Person("linus", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
