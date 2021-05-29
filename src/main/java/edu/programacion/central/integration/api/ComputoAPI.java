package edu.programacion.central.integration.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

import edu.programacion.central.dto.Producto;

import org.springframework.stereotype.Service;

@Service
public class ComputoAPI {

    @Value("${apicomputo.endpoint.producto.get}")
    private String URL_GET;

    @Value("${apicomputo.endpoint.producto.create}")
    private String URL_POST;

    @Value("${apicomputo.endpoint.producto.put}")
    private String URL_PUT;

    @Value("${apicomputo.endpoint.producto.delete}")
    private String URL_DELETE;

    static RestTemplate restTemplate = new RestTemplate();

    public ComputoAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Producto> getProductos(){
        ResponseEntity<List<Producto>> response = restTemplate.
                                    exchange(URL_GET,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Producto>>(){});
        return response.getBody();
    }

    public Producto getProducto(int id){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return restTemplate.getForObject(URL_GET, Producto.class, param);
    }


    public void createProducto(Producto p){
        ResponseEntity<Producto> prod2 = 
            restTemplate.postForEntity(URL_POST, p, Producto.class);
    }

  

}
