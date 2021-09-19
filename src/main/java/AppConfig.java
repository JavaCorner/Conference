import com.ab.util.CalendarFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

/**
 * @author Arpit Bhardwaj
 *
 * In this Spring Java Based Configuration, you will be learning about some Java-based annotations which will help you configure Spring Beans.
 * Using Java based configuration allows you to write your Spring configuration without using XML
 *
 * @Configuration annotation indicates that Spring IoC container can use it as a source of Beans definitions
 * @Bean tells spring that method will return an object which should be registered as a bean in Spring application context.
 * @Bean is method level annotation
 *
 * Stereotype Annotation
 * @Component
 * @Repository annotation is a specialization of the @Component annotation with similar use and functionality.
 * @Service
 *
 * Spring Bean Scopes
 * singleton    – only one instance of the spring bean will be created for the spring container.
 *              This is the default spring bean scope.
 *              While using this scope, make sure bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues.
 * prototype    – new instance will be created every time the bean is requested from the spring container.
 * request      – This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
 * session      – new instance will be created for each HTTP session by the container.
 * application  - creates the bean instance for the lifecycle of a ServletContext.
 *              This is similar to the singleton scope, but there is a very important difference with regards to the scope of the bean.
 *              When beans are application scoped, the same instance of the bean is shared across multiple servlet-based applications running in the same ServletContext,
 *              while singleton scoped beans are scoped to a single application context only.
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
