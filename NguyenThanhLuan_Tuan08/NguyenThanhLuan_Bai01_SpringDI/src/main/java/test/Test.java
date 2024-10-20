package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Employee;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
       
        Employee emp = (Employee) context.getBean("emp");
        emp.show();
        
        context.close();
    }

}
