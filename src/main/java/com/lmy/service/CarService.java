package com.lmy.service;

import com.github.pagehelper.PageInfo;
import com.lmy.entity.Car;
import com.lmy.entity.CarVO;

public interface CarService {

	PageInfo<Car> select(CarVO carVo,int pageNum,int pageSize);
	void add(Car car);
}
