package edu.programacion.central.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.programacion.central.domain.APIProducto;

public class RestClient {
    private static final String URL_BASE = "https://usmpcomputo-api.herokuapp.com/api/producto";

    private static final String GET_PRODUCTOS_API = URL_BASE+"/Producto/";
    private static final String GET_PRODUCTO_BY_ID_API = URL_BASE+"/Producto/{id}";
    private static final String POST_PRODUCTO_API = URL_BASE+"/Create";
    private static final String PUT_PRODUCTO_BY_ID_API = URL_BASE+"/Update";
    private static final String DELETE_PRODUCTO_BY_ID_API = URL_BASE+"/Delete/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        // callAllProducts();
        // callProductById(1);
        // callCreateProduct();
        // callUpdateProduct(18);
        // callDeleteProduct(18);
    }

    private static void callAllProducts() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_PRODUCTOS_API, HttpMethod.GET, entity, String.class);
        System.out.println(result);
    }

    private static void callProductById(int id) {

        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        APIProducto prod = restTemplate.getForObject(GET_PRODUCTO_BY_ID_API, APIProducto.class, param);
        System.out.println(prod.getId());
        System.out.println(prod.getNombre());
        System.out.println(prod.getDescripcion());
        System.out.println(prod.getCategoria());
        System.out.println(prod.getImagen());
        System.out.println(prod.getPrecio());
    }
    private static void callCreateProduct() {

        APIProducto prod = new APIProducto("Prueba2","descripcion generica2","categoria generica2","no hay2", 15.1);
        ResponseEntity<APIProducto> prod2 = restTemplate.postForEntity(POST_PRODUCTO_API, prod, APIProducto.class);
        System.out.println(prod2.getBody().toString());
    }
    private static void callUpdateProduct(int id) {

        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        APIProducto updateProd = new APIProducto(id,"Avion de juguete","2 alas 3 ruedas","Juguete","imagenurl", 150.00);
        // ResponseEntity<APIProducto> prod2 = 0;
        // restTemplate.put(PUT_PRODUCTO_BY_ID_API, updateProd, param , APIProducto.class);
        restTemplate.put(PUT_PRODUCTO_BY_ID_API, updateProd, APIProducto.class);
        // System.out.println(prod2);
    }
    private static void callDeleteProduct(int id){

        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        restTemplate.delete(DELETE_PRODUCTO_BY_ID_API, param);
    }

}
