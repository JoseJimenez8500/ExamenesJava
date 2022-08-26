package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Libro;

@Service
public class LibroServiceRestClientImpl implements LibroService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public LibroServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Libro> getLibros() {
		
		logger.info("***OBTENER LISTA DE LIBROS DESDE EL SERVICE REST CLIENTE");
		logger.info("in getLibros(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Libro>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Libro>>() {});

		// get the list of libros from response
		List<Libro> libros = responseEntity.getBody();

		logger.info("in getLibros(): libros" + libros);
		
		return libros;
	}

	@Override
	public Libro getLibro(int theId) {
		logger.info("***OBTENER UN LIBRO DESDE EL SERVICE REST CLIENTE");

		logger.info("in getLibros(): Calling REST API " + crmRestUrl);

		// make REST call
		Libro theLibro = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Libro.class);

		logger.info("in saveLibro(): theLibro=" + theLibro);
		
		return theLibro;
	}

	@Override
	public void saveLibro(Libro theLibro) {

		logger.info("in saveLibro(): Calling REST API " + crmRestUrl);
		
		int employeeId = theLibro.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			logger.info("***SALVAR UN LIBRO DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, theLibro, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN LIBRO DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, theLibro);
		}

		logger.info("in saveCustomer(): success");	
	}

	@Override
	public void deleteLibro(int theId) {
		logger.info("***BORRAR UN LIBRO DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteLibro(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteLibro(): deleted libro theId=" + theId);
	}

}
