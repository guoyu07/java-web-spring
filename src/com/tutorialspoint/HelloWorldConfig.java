package com.tutorialspoint;
import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("singleton")
    public HelloWorld myWorld(){
        HelloWorld obj = new HelloWorld();
        obj.setMessage1("msg1");
        obj.setMessage2("msg2");
        return obj;
    }

}