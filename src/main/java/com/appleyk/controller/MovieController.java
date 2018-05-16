package com.appleyk.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appleyk.master.service.MovieService;
import com.appleyk.result.ResponseResult;

@RestController
@RequestMapping("/appleyk/v1.0.1/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/query")
	public ResponseResult query(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize) throws Exception {

		return new ResponseResult(movieService.queryMovie(pageNum,pageSize));
	}

}
