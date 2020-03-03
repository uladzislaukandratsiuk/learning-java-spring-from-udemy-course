package example.spring.multimodule.service;

import example.spring.multimodule.core.Game;
import example.spring.multimodule.core.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public GameServiceImpl(Game game, MessageGenerator generator) {
        this.game = game;
        this.messageGenerator = generator;
    }

    @PostConstruct
    public void test() {
        log.info("Main message: {}, Number to guess: {}",
                messageGenerator.getMainMessage(), game.getNumber());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameWon();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
