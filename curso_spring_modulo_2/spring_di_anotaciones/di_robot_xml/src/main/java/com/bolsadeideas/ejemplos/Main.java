package com.bolsadeideas.ejemplos;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolsadeideas.ejemplos.domain.robot.Robot;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");

        Robot robot = (Robot) factory.getBean("robot");
        robot.moverRobot();
	}

}