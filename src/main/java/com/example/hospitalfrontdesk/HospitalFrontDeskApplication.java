package com.example.hospitalfrontdesk;

import java.io.StringWriter;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.hospitalfrontdesk.dto.SpecialistDto;
import com.example.hospitalfrontdesk.exception.ClientErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableCaching
public class HospitalFrontDeskApplication  {

	@Value("${endpoint.specialist}")
	private String specialistUri;
	@Value("${specialistType}")
	private String specialistType;
	@Value("${hospitalName}")
	private String hospitalName;

	public static void main(String[] args) {
		SpringApplication.run(HospitalFrontDeskApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		fetchSpecialistTypeInJson();
		System.out.println("---------------------------------------------------------------------------------------");
		fetchSpecialistTypeInXml();

	}*/

	private void fetchSpecialistTypeInJson() throws JsonProcessingException {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String uri = specialistUri;

		try {
			ResponseEntity<SpecialistDto[]> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
					SpecialistDto[].class, hospitalName, specialistType);

			SpecialistDto[] specialist = response.getBody();

			ObjectMapper obj = new ObjectMapper();
			String json = obj.writeValueAsString(specialist);
			System.out.println("JSON  format: "+json);
			System.out.println("Content Type: "+ response.getHeaders());
		} catch (HttpClientErrorException ex) {

			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new ClientErrorException(ex.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
	}

	private void fetchSpecialistTypeInXml() throws JAXBException {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String uri = specialistUri;
		
		ResponseEntity<SpecialistDto[]> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				SpecialistDto[].class, hospitalName, specialistType);

		SpecialistDto[] specialist = response.getBody();
		
		StringWriter stringWriter = new StringWriter();

	    JAXBContext jaxbContext = JAXBContext.newInstance(SpecialistDto[].class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    // format the XML output
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
	        true);

	    QName qName = new QName("com.example.hospitalfrontdesk.dto", "SpecialistDto");
	    JAXBElement<SpecialistDto[]> root = new JAXBElement<>(qName, SpecialistDto[].class, specialist);

	    jaxbMarshaller.marshal(root, stringWriter);

	    String result = stringWriter.toString();
	    System.out.println("XML format: "+ result);
	    System.out.println("ContentType:"+ response.getHeaders());
		
	}

}
