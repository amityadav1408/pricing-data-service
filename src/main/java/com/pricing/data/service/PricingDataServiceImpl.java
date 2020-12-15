package com.pricing.data.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricing.data.dto.PricingDataJsonVO;
import com.pricing.data.dto.PricingDataXMLVO;

@Service
public class PricingDataServiceImpl implements PricingDataService {

	@Override
	public List<PricingDataJsonVO> getPricingDataInJson() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<PricingDataJsonVO>> typeReference = new TypeReference<List<PricingDataJsonVO>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/jsondata");
		System.out.println("Inputstream:::"+inputStream);
		List<PricingDataJsonVO> pricingDataJsonVO=null ;
			try {
				pricingDataJsonVO = mapper.readValue(inputStream,typeReference);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("exception in converion file to json"+e.getMessage());
				e.printStackTrace();
			} 
			System.out.println("pricingDataJsonVO onversion!");
		
		return pricingDataJsonVO;
	}

	@Override
	public List<PricingDataXMLVO> getPricingDataInXML() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<PricingDataXMLVO>> typeReference = new TypeReference<List<PricingDataXMLVO>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/xmldata");
		System.out.println("Inputstream:::"+inputStream);
		List<PricingDataXMLVO> pricingDataXmlVO=null ;
			try {
				pricingDataXmlVO = mapper.readValue(inputStream,typeReference);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("exception in converion file to json"+e.getMessage());
				e.printStackTrace();
			} 
			System.out.println("pricingDataJsonVO onversion!");
		
		return pricingDataXmlVO;
	}

	@Override
	public InputStreamResource getPricingDataInCSV() {
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data.csv");
		InputStreamResource inputStreamRes= new InputStreamResource(inputStream);
		System.out.println("Inputstream::"+inputStream);
		return inputStreamRes;
	}

}
