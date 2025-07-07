package br.com.prodemge.DORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prodemge.DORA.service.HelloWorldService;

@RestController
@RequestMapping("/hello")
class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/world")
    public String helloWorld() {
        return helloWorldService.getHelloWorldMessage("padrao");

    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return helloWorldService.getHelloWorldMessage(name);
    }
}