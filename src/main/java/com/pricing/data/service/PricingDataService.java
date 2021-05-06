package com.pricing.data.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pricing.data.dto.PaymentNotificationDetails;
import com.pricing.data.dto.PricingDataJsonVO;
import com.pricing.data.dto.PricingDataXMLVO;

@Service
public interface PricingDataService {

	List<PricingDataJsonVO> getPricingDataInJson();

	List<PricingDataXMLVO> getPricingDataInXML();

	InputStreamResource getPricingDataInCSV();

	String savePricingDataInJson(PricingDataJsonVO pricingDataJsonVO) throws JsonProcessingException, URISyntaxException;
	
	PaymentNotificationDetails getPaymentDetails(PaymentNotificationDetails details);
}
