import com.ab.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arpit Bhardwaj
 */
public class Application {

    public static void main(String[] args) {

        //This is the hardcoded injection need to do if we don't use Spring
        //SpeakerService service = new SpeakerServiceImpl();

        //to activate xml based configuration
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //to activate java based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpeakerService service = context.getBean("speakerService",SpeakerService.class);
        System.out.println(service.findAll().get(0).getFirstName());
        System.out.println(service.findAll().get(0).getSeedNum());

        //SpeakerService service2 = context.getBean("speakerService",SpeakerService.class);
        //System.out.println(service2);
    }
}
