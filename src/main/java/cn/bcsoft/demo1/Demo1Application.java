package cn.bcsoft.demo1;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args){
		System.out.println("demo1");

		try {
			Tomcat tomcat = new Tomcat();
			tomcat.setPort(8081);
			tomcat.addWebapp("/", "");
			tomcat.start();
		} catch (LifecycleException e) {
			System.out.println("demo1: "+ e.getLocalizedMessage());
		}


		SpringApplication.run(Demo1Application.class, args);
	}

}
