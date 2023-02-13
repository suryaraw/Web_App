package com.black.SpringJdbcConnector1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("JDBC Through Spring !!");
    	
   
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
    	JDBC jdbc = context.getBean("jdbc",JDBC.class);
    	jdbc.display();
    	jdbc.insertValues();
    }
}
