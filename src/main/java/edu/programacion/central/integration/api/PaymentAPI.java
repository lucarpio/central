package edu.programacion.central.integration.api;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.programacion.central.dto.Card;
import edu.programacion.central.dto.Payment;
import edu.programacion.central.dto.RegisterCard;

@Service
public class PaymentAPI {

    @Value("${apipayment.endpoint.get.cards}")
    private String URL_GET_CARDS;
    @Value("${apipayment.endpoint.delete.card}")
    private String URL_DELETE_CARD;//falta
    @Value("${apipayment.endpoint.post.registercard}")
    private String URL_POST_REGISTER_CARD;
    @Value("${apipayment.endpoint.get.customers}")
    private String URL_GET_CUSTOMERS;//no implementado (repetido)
    @Value("${apipayment.endpoint.get.customercard}")
    private String URL_GET_CUSTOMER_CARD;//falta
    @Value("${apipayment.endpoint.post.createcustomer}")
    private String URL_POST_CREATE_CUSTOMER;
    @Value("${apipayment.endpoint.post.createpayment}")
    private String URL_POST_CREATE_PAYMENT;

    static RestTemplate restTemplate = new RestTemplate();

    public PaymentAPI(RestTemplate restTemplate) {
        PaymentAPI.restTemplate = restTemplate;
    }

    public List<Payment> getPayment() {
        ResponseEntity<List<Payment>> response = restTemplate.exchange(URL_GET_CARDS, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Payment>>() {
                });
        return response.getBody();
    }

    public List<Card> getCards() {
        ResponseEntity<List<Card>> response = restTemplate.exchange(URL_GET_CUSTOMER_CARD, HttpMethod.GET,
                HttpEntity.EMPTY, new ParameterizedTypeReference<List<Card>>() {
                });
        return response.getBody();
    }

    public void postCards(RegisterCard c) {
        HttpEntity<RegisterCard> bodyRequest = new HttpEntity<RegisterCard>(c);
        ResponseEntity<String> response = restTemplate.exchange(URL_POST_REGISTER_CARD, HttpMethod.POST, bodyRequest,
                new ParameterizedTypeReference<String>() {
                });
    }

    public void postPayments(Payment p) {
        HttpEntity<Payment> bodyRequest = new HttpEntity<Payment>(p);
        ResponseEntity<String> response = restTemplate.exchange(URL_POST_CREATE_PAYMENT, HttpMethod.POST, bodyRequest,
                new ParameterizedTypeReference<String>() {
                });
    }

    //TODO delete card

    //TODO get card by customerId
    
}