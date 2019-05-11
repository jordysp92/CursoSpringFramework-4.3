package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolsadeideas.ejemplos.domain.robot.Robot;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		BeanFactory ctx = new ClassPathXmlApplicationContext("/beans.xml");

        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.scan("com.bolsadeideas.ejemplos.domain.robot");
        //ctx.refresh();

        Robot robot = (Robot) ctx.getBean("robot");
        robot.moverRobot();
	}

}