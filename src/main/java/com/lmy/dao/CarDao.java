package com.lmy.dao;

import java.util.List;

import com.lmy.entity.Car;
import com.lmy.entity.CarVO;

public interface CarDao {

	List<Car> select(CarVO carVo);
	
	void add(Car car);
}
