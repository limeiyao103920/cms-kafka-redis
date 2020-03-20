package com.lmy.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.kafka.listener.MessageListener;

import com.lmy.entity.Car;
import com.lmy.service.CarService;

public class MsgListener implements MessageListener<String, String> {

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	CarService carService;
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String value = data.value();
		System.err.println("kafka收到"+value);
		//从redis获取数据
		Car car = (Car)redisTemplate.opsForValue().get(value);
		//存入数据库
		carService.add(car);
		System.err.println("保存成功到mysql");
		//删除redis中记录
		redisTemplate.delete(value);
	}

}
