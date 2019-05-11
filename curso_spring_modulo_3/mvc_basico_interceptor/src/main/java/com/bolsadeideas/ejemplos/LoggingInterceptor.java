package com.bolsadeideas.ejemplos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	logger.info("*****LoggingInterceptor: preHandle() entrando, antes de invocar el metodo Handler");
        return true;
    }

    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
			   ModelAndView modelAndView) throws Exception {
    	logger.info("*****LoggingInterceptor: postHandle() saliendo, despues de invocar el metodo Handler");
    }
}
