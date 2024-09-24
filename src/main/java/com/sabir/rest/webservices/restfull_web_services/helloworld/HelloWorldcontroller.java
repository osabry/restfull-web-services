package com.sabir.rest.webservices.restfull_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldcontroller {

    private MessageSource messageSource;

    public HelloWorldcontroller(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World ! Welcome to my Java ";
    }

    @RequestMapping("/hello-international")
    public String helloWorldInternational() {

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @RequestMapping("/hellobeans")
    public HelloBean helloBeans() {
        return new HelloBean("Hello Beans");
    }

    // Path parameter 
    @GetMapping("/hellobeans/path/{name}")
    public HelloBean helloBeansPathVariable( @PathVariable("name") String name ) {
        return new HelloBean(String.format("Hello Beans  %s" ,name ));
    }


}
