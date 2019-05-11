package com.bolsadeideas.ejemplos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolsadeideas.ejemplos.dao.EstudianteDao;
import com.bolsadeideas.ejemplos.entity.Estudiante;

import java.util.GregorianCalendar;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

			EstudianteDao estudianteDao = (EstudianteDao) context.getBean("estudianteDao");

			Estudiante estudiante = new Estudiante();
			estudiante.setNombre("Andrés Guzmán");
			estudiante.setFechaNacimiento(new GregorianCalendar(1978, 1, 1).getTime());
			estudiante.setPromedio(8);
			estudianteDao.save(estudiante);

			List<Estudiante> estudiantes = estudianteDao.findAll();
			Integer estudianteId = estudiantes.get(0).getId();

			estudiante = estudianteDao.findById(estudianteId);
			System.out.println("--->ID: " + estudiante.getId());
			System.out.println("--->Nombre: " + estudiante.getNombre());
			System.out.println("--->Fecha Nacimiento: " + estudiante.getFechaNacimiento());
			System.out.println("--->Promedio: " + estudiante.getPromedio());

			estudianteDao.delete(estudiante);
		}
	}
}
