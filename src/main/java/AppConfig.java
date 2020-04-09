import com.ab.model.Speaker;
import com.ab.repository.HibernateSpeakerRepositoryImpl;
import com.ab.repository.SpeakerRepository;
import com.ab.service.SpeakerService;
import com.ab.service.SpeakerServiceImpl;
import com.ab.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

/**
 * @author Arpit Bhardwaj
 *
 * In this Spring Java Based Configuration, you will be learning about some Java-based annotations which will help you configure Spring Beans.
 * Using Java based configuration allows you to write your Spring configuration without using XML
 *
 * Beans are singleton by default
 *
 * @Configuration annotation indicates that Spring IoC container can use it as a source of Beans definitions
 * @Bean tells Spring that method will return an object which should be registered as a bean in Spring application context.
 * @Bean is method level annotation
 *
 * Stereotype Annotation
 * @Component
 * @Repository annotation is a specialization of the @Component annotation with similar use and functionality.
 *
 *
 */


@Configuration
@ComponentScan("com.ab")
public class AppConfig {

    @Bean(name="calendar")
    public CalendarFactory calendarFactory(){
        CalendarFactory calendarFactory = new CalendarFactory();
        calendarFactory.addDays(2);
        return calendarFactory;
    }

    @Bean
    public Calendar calendar() throws Exception {
        return calendarFactory().getObject();
    }

    /*@Bean(name = "speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService(){
        //constructor injection
        //SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        //setter injection
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        //setter injection can also be auto wired by marking setter as AutoWired
        //service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }*/
}
