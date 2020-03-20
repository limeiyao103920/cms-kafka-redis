package com.lmy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.dao.CarDao;
import com.lmy.entity.Car;
import com.lmy.entity.CarVO;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarDao carDao;
	@Override
	public PageInfo<Car> select(CarVO carVo,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Car>(carDao.select(carVo));
	}
	@Override
	public void add(Car car) {
		// TODO Auto-generated method stub
		carDao.add(car);
	}

}
