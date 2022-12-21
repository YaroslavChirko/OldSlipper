package com.slippers.micro.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slippers.micro.data.model.Slipper;

@RestController
@RequestMapping(path = "/slippers")
public class SlipperController {
	
	private static List<Slipper> slipperStore = new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<List<Slipper>> getSlippers(){
		return new ResponseEntity<List<Slipper>>(slipperStore, HttpStatus.OK);
	}
	
	
	@PostMapping
	public HttpStatus postSlipper(@RequestBody(required = false) Slipper slipper) {
		if(slipper == null) return HttpStatus.BAD_REQUEST;
		slipperStore.add(slipper);
		return HttpStatus.OK;
	}
	
	
}