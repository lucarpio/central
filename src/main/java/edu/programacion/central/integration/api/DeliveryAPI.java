package edu.programacion.central.integration.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.programacion.central.dto.Delivery;
import edu.programacion.central.dto.Pedido;

public class DeliveryAPI {
    // private String URL_GET_CATEGORIA;
    // private String URL_GET_CATEGORIA_BYID;
    // private String URL_POST_CATEGORIA;
    // private String URL_PUT_CATEGORIA;
    // private String URL_DELETE_CATEGORIA;
    @Value("${apidelivery.endpoint.delivery.get}")
    private String URL_GET_DELIVERY;
    @Value("${apidelivery.endpoint.delivery.get}")
    private String URL_GET_DELIVERY_BYID;
    @Value("${apidelivery.endpoint.delivery.create}")
    private String URL_POST_DELIVERY;
    @Value("${apidelivery.endpoint.delivery.put}")
    private String URL_PUT_DELIVERY;
    @Value("${apidelivery.endpoint.delivery.delete}")
    private String URL_DELETE_DELIVERY;
    @Value("${apidelivery.endpoint.get}")
    private String URL_GET_PEDIDO;
    @Value("${apidelivery.endpoint.get}")
    private String URL_GET_PEDIDO_BYID;
    @Value("${apidelivery.endpoint.create}")
    private String URL_POST_PEDIDO;
    @Value("${apidelivery.endpoint.put}")
    private String URL_PUT_PEDIDO;
    @Value("${apidelivery.endpoint.delete}")
    private String URL_DELETE_PEDIDO;

    static RestTemplate restTemplate = new RestTemplate();

    public DeliveryAPI(RestTemplate restTemplate){
        DeliveryAPI.restTemplate = restTemplate;
    }

    public List<Delivery> getDelivery() {
        ResponseEntity<List<Delivery>> response = restTemplate.exchange(URL_GET_DELIVERY, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Delivery>>() {
                });
        return response.getBody();
    }

    public Delivery getDelivery(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return restTemplate.getForObject(URL_GET_DELIVERY_BYID, Delivery.class, param);
    }

    public void createDelivery(Delivery delivery) {
        HttpEntity<Delivery> bodyRequest = new HttpEntity<Delivery>(delivery);
        ResponseEntity<String> response = restTemplate.exchange(URL_POST_DELIVERY, HttpMethod.POST, bodyRequest,
                new ParameterizedTypeReference<String>() {
                });
    }

    public void deleteDelivery(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id_tracking", id);
        restTemplate.delete(URL_DELETE_DELIVERY, param);
        // HttpEntity<Delivery> bodyRequest = new HttpEntity<Delivery>(delivery);
        // ResponseEntity<String> response = restTemplate.exchange(URL_DELETE_DELIVERY, HttpMethod.DELETE, bodyRequest,
        //         new ParameterizedTypeReference<String>() {
        //         });
    }

    public List<Pedido> getPedido() {
        ResponseEntity<List<Pedido>> response = restTemplate.exchange(URL_GET_DELIVERY, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Pedido>>() {
                });
        return response.getBody();
    }

    public Pedido getPedido(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return restTemplate.getForObject(URL_GET_DELIVERY_BYID, Pedido.class, param);
    }

    public void createPedido(Pedido pedido) {
        HttpEntity<Pedido> bodyRequest = new HttpEntity<Pedido>(pedido);
        ResponseEntity<String> response = restTemplate.exchange(URL_POST_DELIVERY, HttpMethod.POST, bodyRequest,
                new ParameterizedTypeReference<String>() {
                });
    }

    public void deletePedido(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        restTemplate.delete(URL_DELETE_PEDIDO, param);
        // HttpEntity<Delivery> bodyRequest = new HttpEntity<Delivery>(delivery);
        // ResponseEntity<String> response = restTemplate.exchange(URL_DELETE_DELIVERY, HttpMethod.DELETE, bodyRequest,
        //         new ParameterizedTypeReference<String>() {
        //         });
    }
}
