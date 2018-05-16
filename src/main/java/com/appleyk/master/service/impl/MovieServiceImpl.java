package com.appleyk.master.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appleyk.master.entity.MovieEntity;
import com.appleyk.master.mapper.MovieMapper;
import com.appleyk.master.service.MovieService;
import com.appleyk.paging.PageInfo;
import com.appleyk.result.ResponseMessage;
import com.appleyk.result.ResultData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public ResultData<MovieEntity> queryMovie(Integer pageNum,Integer pageSize) {

		/**
		 * 分页拦截器，设置查询要显示的起始页和数量
		 */
		PageHelper.startPage(pageNum, pageSize);
		
		Example example = new Example(MovieEntity.class);
		
		/**
		 * 转page
		 */
		Page<MovieEntity> movieEntities =  (Page<MovieEntity>) movieMapper.selectByExample(example);
		
		/**
		 * 转pageinfo == 【包含total == 记录总数量 和 pages == 总页数】
		 */
		PageInfo<MovieEntity> pageInfo = new PageInfo<>(movieEntities);
		
		/**
		 * 构造返回结果
		 */
		ResultData<MovieEntity> resultData = new ResultData<>(ResponseMessage.OK, pageInfo);
		
		return resultData;
	}

}
