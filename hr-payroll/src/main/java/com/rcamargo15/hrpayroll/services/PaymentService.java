package com.rcamargo15.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rcamargo15.hrpayroll.entities.Payment;
import com.rcamargo15.hrpayroll.entities.Worker;
import com.rcamargo15.hrpayroll.feignclientes.WorkerFeignClient;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String HR_WORKER;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
    public Payment getPayment(long workerId, int days){
    	
//    	Map<String, String> uriVariable = new HashMap<>();
//    	uriVariable.put("id", String.valueOf(workerId));
//    	HttpEntity<Object> entity = new HttpEntity<>(uriVariable); 
//    	ResponseEntity<Worker> worker = restTemplate.exchange(HR_WORKER.concat(String.valueOf(workerId)), HttpMethod.GET, entity, Worker.class, uriVariable);
    	Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
