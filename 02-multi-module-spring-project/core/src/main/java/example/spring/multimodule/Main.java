package example.spring.multimodule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private final static String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {

        log.info("Guess the number game");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("number = {}", number);

        Game game = context.getBean(Game.class);

        context.close();
    }
}
