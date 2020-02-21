package example.spring.multimodule.config;

import example.spring.multimodule.core.GuessCount;
import example.spring.multimodule.core.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:game.properties")
public class GameConfig {

    @Value("${game.maxNumber:50}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
