package com.pricing.data.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricing.data.dto.PaymentNotificationDetails;
import com.pricing.data.dto.PricingDataJsonVO;
import com.pricing.data.dto.PricingDataXMLVO;

@Service
public class PricingDataServiceImpl implements PricingDataService {

	@Override
	public List<PricingDataJsonVO> getPricingDataInJson() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<PricingDataJsonVO>> typeReference = new TypeReference<List<PricingDataJsonVO>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/jsondata");
		System.out.println("Inputstream:::" + inputStream);
		List<PricingDataJsonVO> pricingDataJsonVO = null;
		try {
			pricingDataJsonVO = mapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception in converion file to json" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("pricingDataJsonVO onversion!");

		return pricingDataJsonVO;
	}

	@Override
	public List<PricingDataXMLVO> getPricingDataInXML() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<PricingDataXMLVO>> typeReference = new TypeReference<List<PricingDataXMLVO>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/xmldata");
		System.out.println("Inputstream:::" + inputStream);
		List<PricingDataXMLVO> pricingDataXmlVO = null;
		try {
			pricingDataXmlVO = mapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception in converion file to json" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("pricingDataJsonVO onversion!");

		return pricingDataXmlVO;
	}

	@Override
	public InputStreamResource getPricingDataInCSV() {
		InputStream inputStream = TypeReference.class.getResourceAsStream("/csvdata");
		InputStreamResource inputStreamRes = new InputStreamResource(inputStream);
		System.out.println("Inputstream::" + inputStream);
		return inputStreamRes;
	}

	@Override
	public String savePricingDataInJson(PricingDataJsonVO pricingDataJsonVO)
			throws JsonProcessingException, URISyntaxException {

		String fileName = "jsondata";
		PricingDataServiceImpl app = new PricingDataServiceImpl();
		// System.out.println("getResourceAsStream : " + fileName);
		//InputStream is = app.getFileFromResourceAsStream(fileName);
		InputStream inputStream = TypeReference.class.getResourceAsStream("/jsondata");
		printInputStream(inputStream);

		// System.out.println("\ngetResource : " + fileName);
		//File file = app.getFileFromResource(fileName);
		Path path2 = Paths.get("jsondata");
		// file reading
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(pricingDataJsonVO);
		System.out.println(jsonString);
		String s;
		try {
			System.out.println("path2:::::"+path2.toRealPath().toString());
			FileReader fr = new FileReader(path2.toRealPath().toString());
			BufferedReader br = new BufferedReader(fr);
			System.out.println("FRFR-----------" + fr + "::" + br);
			StringBuffer sbf = new StringBuffer();

			while (br.ready()) {
				System.out.println("-----" + br.readLine());
				/*
				 * if(s.contains("]")) { System.out.println("Inside if block"); StringBuffer
				 * body=new StringBuffer();
				 * body.append(",").append("\n").append(jsonString).append("]"); s= s.replace(s,
				 * body.toString()); System.out.println("=============="+s); }
				 */
				sbf.append(br.readLine()).append("\n");
				// do something with the resulting line
			}
			StringBuffer body = new StringBuffer();
			body.append(",").append("\n").append(jsonString).append("]");
			System.out.println("body===="+body);
			System.out.println("check::"+sbf.toString().contains("]"));
			String payload = sbf.toString().replace("]", body);
			System.out.println("output:::" + payload);
			
			FileWriter writer = new FileWriter(new File(path2.toAbsolutePath().toString()));
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(payload);
			buffer.close();
		} catch (Exception e) {
			System.out.println("Exception e;" + e.getLocalizedMessage());
			return "error while saving data";
		}
		return "data save sucessfully";
	}

	private InputStream getFileFromResourceAsStream(String fileName) {

		// The class loader that loaded the class
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		// the stream holding the file content
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}

	}

	/*
	 * The resource URL is not working in the JAR If we try to access a file that is
	 * inside a JAR, It throws NoSuchFileException (linux), InvalidPathException
	 * (Windows)
	 * 
	 * Resource URL Sample: file:java-io.jar!/json/file1.json
	 */
	private File getFileFromResource(String fileName) throws URISyntaxException {

		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {

			// failed if files have whitespaces or special characters
			// return new File(resource.getFile());

			return new File(resource.toURI());
		}

	}

	// print input stream
	private static void printInputStream(InputStream is) {

		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println("PS"+line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// print a file
	private static void printFile(File file) {

		List<String> lines;
		try {
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static List<PaymentNotificationDetails> detail = new ArrayList<PaymentNotificationDetails>();
	
	@Override
	public PaymentNotificationDetails getPaymentDetails(PaymentNotificationDetails details) {
		detail.add(details);
		return details;
	}
	
	
}
