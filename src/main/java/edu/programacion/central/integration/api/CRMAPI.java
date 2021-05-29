package edu.programacion.central.integration.api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.programacion.central.dto.Customer;
import edu.programacion.central.dto.Complaint;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CRMAPI {
    @Value("${appexternal.endpoint.get.customer}")
    private String URL_GET_CUSTOMER;

    @Value("${appexternal.endpoint.post.customer}")
    private String URL_POST_CUSTOMER;

    @Value("${appexternal.endpoint.get.complaint}")
    private String URL_GET_COMPLAINT;


    private RestTemplate restTemplate;

    public CRMAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Customer> getCustomers(){
        ResponseEntity<List<Customer>> response = restTemplate.
                                    exchange(URL_GET_CUSTOMER,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Customer>>(){});
        return response.getBody();
    }

    public List<Complaint> getComplaints(){
        ResponseEntity<List<Complaint>> response = restTemplate.
                                    exchange(URL_GET_COMPLAINT,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Complaint>>(){});
        return response.getBody();
    }


    public void postCustomers(Customer e){
        HttpEntity<Customer> bodyRequest = new  HttpEntity<Customer>(e);
        ResponseEntity<String> response = 
            restTemplate.exchange(URL_POST_CUSTOMER, 
                        HttpMethod.POST,bodyRequest,
                        new ParameterizedTypeReference<String>(){
                }
            );
    }
}
