package com.bolsadeideas.ejemplos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TiempoTranscurridoInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);

		try {
			Random rand = new Random();

			Thread.sleep(rand.nextInt(500));
		} catch (InterruptedException ie) {
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		request.removeAttribute("tiempoInicio");
		long tiempoFin = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + " milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo");
	}
}
