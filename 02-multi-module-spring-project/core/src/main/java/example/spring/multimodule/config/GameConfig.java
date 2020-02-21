package example.spring.multimodule.config;

import example.spring.multimodule.core.GuessCount;
import example.spring.multimodule.core.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    private int maxNumber = 50;

    private int guessCount = 10;

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
