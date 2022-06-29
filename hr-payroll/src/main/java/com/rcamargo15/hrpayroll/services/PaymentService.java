package com.rcamargo15.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rcamargo15.hrpayroll.entities.Payment;
import com.rcamargo15.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String HR_WORKER;
	
	@Autowired
	private RestTemplate restTemplate;
	
    public Payment getPayment(long workerId, int days){
    	
    	Map<String, String> uriVariable = new HashMap<>();
    	uriVariable.put("id", String.valueOf(workerId));
    	
    	HttpEntity<Object> entity = new HttpEntity<>(uriVariable); 
    	
    	ResponseEntity<Worker> worker = restTemplate.exchange(HR_WORKER.concat(String.valueOf(workerId)), HttpMethod.GET, entity, Worker.class, uriVariable);
    	Worker w1 = worker.getBody();
    	
        return new Payment(w1.getName(), w1.getDailyIncome(), days);
    }
}
