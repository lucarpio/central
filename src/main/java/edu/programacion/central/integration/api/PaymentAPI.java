package edu.programacion.central.integration.api;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

@Service
public class PaymentAPI {

    @Value("${apipayment.endpoint.get.cards}")
    private String URL_GET_CARDS;
    @Value("${apipayment.endpoint.delete.card}")
    private String URL_DELETE_CARD;
    @Value("${apipayment.endpoint.post.registercard}")
    private String URL_POST_REGISTER_CARD;
    @Value("${apipayment.endpoint.get.customers}")
    private String URL_GET_CUSTOMERS;
    @Value("${apipayment.endpoint.get.customercard}")
    private String URL_GET_CUSTOMER_CARD;
    @Value("${apipayment.endpoint.post.createcustomer}")
    private String URL_POST_CREATE_CUSTOMER;
    @Value("${apipayment.endpoint.post.createpayment}")
    private String URL_POST_CREATE_PAYMENT;

    static RestTemplate restTemplate = new RestTemplate();

    public PaymentAPI(RestTemplate restTemplate) {
        PaymentAPI.restTemplate = restTemplate;
    }
}