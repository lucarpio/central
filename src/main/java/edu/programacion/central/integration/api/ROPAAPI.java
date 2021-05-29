package edu.programacion.central.integration.api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.programacion.central.dto.Ropa;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ROPAAPI {
    @Value("${appexternal.endpoint.get.ropa}")
    private String URL_GET_ROPA;

    private RestTemplate restTemplate;

    public ROPAAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Ropa> getRopas(){
        ResponseEntity<List<Ropa>> response = restTemplate.
                                    exchange(URL_GET_ROPA,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Ropa>>(){});
        return response.getBody();
    }

}
