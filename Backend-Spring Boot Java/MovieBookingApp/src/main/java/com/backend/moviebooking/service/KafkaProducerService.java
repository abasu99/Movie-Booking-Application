//package com.backend.moviebooking.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducerService {
//	
//	public static final String topic ="addmovie";
//	
//	@Autowired
//	private KafkaTemplate<String, String> data;
//	
//	public static String getTopic() {
//		return topic;
//	}
//	
//	public KafkaTemplate<String, String> getData() {
//		return data;
//	}
//
//	public void setData(String msg)
//	{
//		this.data.send(topic, msg);
//	}
//
//}
