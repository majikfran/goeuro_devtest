package me.fcbwilliams.goeuro.devtest;

import me.fcbwilliams.goeuro.devtest.Spring.SpringConfiguration;
import me.fcbwilliams.goeuro.devtest.UI.interfaces.IUserInterface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;


/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	SimpleCommandLinePropertySource clps = new SimpleCommandLinePropertySource(args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().getPropertySources().addFirst(clps);
        ctx.register(SpringConfiguration.class);
        ctx.refresh();
        
        ctx.getBean(IUserInterface.class).start();
        ctx.close();
    }
}
