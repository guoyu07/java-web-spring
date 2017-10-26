package com.tutorialspoint;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class MainApp {

    private void useBeanFactory() {
        // beanfactory已经被废弃，不建议使用
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
    }

    private void useApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");

        TextEditor editor = (TextEditor)context.getBean("textEditor");

        editor.spellCheck();

        System.out.println(editor.getArr());
        System.out.println(editor.getKv());

        Student student = (Student) context.getBean("student");
        System.out.println("Name : " + student.getName() );
        System.out.println("Age : " + student.getAge() );

        context.registerShutdownHook();


        AnnotationConfigApplicationContext annoContext = new AnnotationConfigApplicationContext();
        annoContext.register(HelloWorldConfig.class);
        annoContext.refresh();

        HelloWorld myWorld = (HelloWorld) annoContext.getBean("myWorld");
        myWorld.getMessage1();
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.useBeanFactory();
        app.useApplicationContext();
    }
}