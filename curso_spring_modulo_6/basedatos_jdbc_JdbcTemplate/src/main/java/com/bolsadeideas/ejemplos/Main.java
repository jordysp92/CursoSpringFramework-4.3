package com.bolsadeideas.ejemplos;

import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolsadeideas.ejemplos.dao.EstudianteDao;
import com.bolsadeideas.ejemplos.entity.Estudiante;

public class Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

			EstudianteDao estudianteDao = (EstudianteDao) context.getBean("estudianteDao");
			Estudiante estudiante = new Estudiante(0001, "Andrés Guzmán", new GregorianCalendar(1978, 1, 1).getTime(),
					10);

			estudianteDao.save(estudiante);

			estudiante = estudianteDao.findById(0001);
			System.out.println("--->ID: " + estudiante.getId());
			System.out.println("--->Nombre: " + estudiante.getNombre());
			System.out.println("--->Fecha Nacimiento: " + estudiante.getFechaNacimiento());
			System.out.println("--->Promedio: " + estudiante.getPromedio());
			System.out.println("--->Total Estudiantes: " + estudianteDao.count());
			System.out.println("--->Obtener por Nombre: " + estudianteDao.getNombre(0001));
		}
	}
}