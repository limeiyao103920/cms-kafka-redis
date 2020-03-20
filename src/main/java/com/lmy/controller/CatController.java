package com.lmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lmy.entity.Car;
import com.lmy.entity.CarVO;
import com.lmy.service.CarService;

@Controller
public class CatController {

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	KafkaTemplate<String, String> 	kafkaTemplate;
	@Autowired
	CarService carService;
	@RequestMapping("list")
	public String select(CarVO carVo,Model model,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "5")int pageSize) {
		PageInfo<Car> info = carService.select(carVo, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("carVo", carVo);
		System.out.println("info");
		return "list";
	}
	
	@GetMapping("add")
	public String toAdd() {
		return "add";
	}
	
	@PostMapping("add")
	public String add(Car car) {
		System.err.println(car+"111111111111");
		//将试驾测评记录保存到Redis中
		redisTemplate.opsForValue().set("car", car);
		System.err.println("保存到redis");
		//向Kafka发送消息Redis的key
		kafkaTemplate.send("1710f", "car");
		System.err.println("发送到kafka");
		System.err.println("111111111111111111111111111111111");
		return "redirect:list";
	}
}
