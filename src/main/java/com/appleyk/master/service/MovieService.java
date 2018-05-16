package com.appleyk.master.service;

import com.appleyk.master.entity.MovieEntity;
import com.appleyk.result.ResultData;

public interface MovieService {

	ResultData<MovieEntity> queryMovie(Integer pageNum,Integer pageSize);
}
