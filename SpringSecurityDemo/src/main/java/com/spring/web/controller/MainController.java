package com.spring.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.enums.Response;
import com.spring.exception.ResourceNotFoundException;
import com.spring.response.BaseResponse;
import com.spring.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "MainController", description = "Spring security controller")
public class MainController {

	@ApiOperation(value = "Index page", response = Iterable.class, tags = "index")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public final ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		if (CommonUtil.checkUserLogin()) {
			//model.setViewName("index");
		} else {
			model.setViewName("redirect:/");
		}
		return model;
	}

	private String getErrorMessage(final HttpServletRequest request, final String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}
		return error;
	}

	@RequestMapping(value = {"/403", "/400", "/404"}, method = RequestMethod.GET)
	public final ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("error");
		return model;
	}
}