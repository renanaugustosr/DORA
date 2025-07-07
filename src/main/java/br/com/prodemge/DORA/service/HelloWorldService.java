package br.com.prodemge.DORA.service;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getHelloWorldMessage(String name) {
        return "Hello, "+name+"!";
    }
    
    // Additional methods can be added here for more complex logic
    // For example, you could add methods to handle different greetings or messages
}
