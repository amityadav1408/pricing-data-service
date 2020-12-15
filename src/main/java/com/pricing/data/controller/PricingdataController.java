/**
 * 
 */
package com.pricing.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.data.dto.PricingDataJsonVO;
import com.pricing.data.service.PricingDataService;

/**
 * @author amit
 *
 */
@RestController
@RequestMapping("/pricing")
public class PricingdataController {
	@Autowired
	PricingDataService pricingDataService;

	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PricingDataJsonVO> getPricingInJson() {
		return pricingDataService.getPricingDataInJson();
	}

	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<PricingDataJsonVO> getPricingInXML() {
		return pricingDataService.getPricingDataInJson();
		// return pricingDataService.getPricingDataInXML();
	}

	@GetMapping("/csv")
	public ResponseEntity<Resource> getFile() {
		String filename = "pricing-data.csv";
		InputStreamResource file = pricingDataService.getPricingDataInCSV();
		System.out.println("file:::" + file);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/csv")).body(file);
	}

}
