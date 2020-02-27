package example.spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getHelloMessage(String user) {
        return "Hello, " + user + " from DemoServiceImpl method getHelloMessage!";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome from DemoServiceImpl method getWelcomeMessage!";
    }
}