package com.italoalmeida.hc.restcontroller;

import static com.italoalmeida.hc.utils.Endpoint.INFO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = INFO)
public class InfoRestController {
	
	@GetMapping
	private ResponseEntity<Object> info(HttpServletRequest request) {		
		// Response
		return ResponseEntity.ok().body("info");
	}

}
