package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{
    Dependency1 dependency1;

    Dependency2 dependency2;

//    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //    public Dependency1 getDependency1() {
//        return dependency1;
//    }

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }

//    public Dependency2 getDependency2() {
//        return dependency2;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1{

}
@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
