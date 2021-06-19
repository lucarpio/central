package edu.programacion.central.integration.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.programacion.central.dto.Factura;
@Service
public class SunatAPI {
    @Value("${apisunat.endpoint.factura.get}")
    private String URL_GET_FACTURA;
    @Value("${apisunat.endpoint.factura.get}")
    private String URL_GET_FACTURA_BYID;
    @Value("${apisunat.endpoint.factura.create}")
    private String URL_POST_FACTURA;
    @Value("${apisunat.endpoint.factura.put}")
    private String URL_PUT_FACTURA;
    @Value("${apisunat.endpoint.factura.delete}")
    private String URL_DELETE_FACTURA;

    static RestTemplate restTemplate = new RestTemplate();

    public SunatAPI(RestTemplate restTemplate) {
        SunatAPI.restTemplate = restTemplate;
    }

    public List<Factura> getFactura() {
        ResponseEntity<List<Factura>> response = restTemplate.exchange(URL_GET_FACTURA, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Factura>>() {
                });
        return response.getBody();
    }

    public Factura getFactura(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return restTemplate.getForObject(URL_GET_FACTURA_BYID, Factura.class, param);
    }

    public void createFactura(Factura factura) {
        HttpEntity<Factura> bodyRequest = new HttpEntity<Factura>(factura);
        ResponseEntity<String> response = restTemplate.exchange(URL_POST_FACTURA, HttpMethod.POST, bodyRequest,
                new ParameterizedTypeReference<String>() {
                });
    }

    public void deleteFactura(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        restTemplate.delete(URL_DELETE_FACTURA, param);
    }

}
