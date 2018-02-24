package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
   private static final Logger logger = LogManager.getLogger(GlobalControllerExceptionHandler.class);
	
	@ExceptionHandler
	public void handleGenericException(Exception e,HttpServletResponse response) throws IOException {
		logger.debug(e.getMessage());
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
}
