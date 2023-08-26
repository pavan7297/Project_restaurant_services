package com.restaurent.controller;

import java.sql.SQLDataException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.response.Response;
import com.restaurent.service.GetServices;
import com.restaurent.wrappers.RestaurentWappers;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/get")
@Slf4j
public class getController {

	@Autowired
	private Environment environment;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	GetServices getServiceImpl;

	@GetMapping
	public Response getAllItems() throws SQLDataException, Exception {

		RestaurentWappers wrappers = new RestaurentWappers();

		Object requestIDObject = request.getAttribute("reqid");
		String strRequestID = requestIDObject != null ? requestIDObject.toString() : "DefaultRequestID";
		log.info(strRequestID + "::::getitems() method is executed");

		wrappers.setObjectGet(getServiceImpl.getAllItems(strRequestID));
		wrappers.setResponseCode(HttpStatus.OK.value());
		wrappers.setStatus(HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::OUTPUT:::::" + wrappers.toString());
		return wrappers;
	}
}
