package edu.programacion.central.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.programacion.central.dto.Delivery;
import edu.programacion.central.dto.Pedido;
import edu.programacion.central.integration.api.DeliveryAPI;

public class DeliveryController {
    private final DeliveryAPI deliveryAPI;
    private static final String DELIVERY_LIST = "delivery/list";
    private static final String DELIVERY_BYID = "delivery/{id}";
    private static final String DELIVERY_CREATE = "delivery/create";
    private static final String DELIVERY_PUT = "delivery/modify";
    private static final String DELIVERY_DELETE = "delivery/delete/{id}";
    private static final String PEDIDO_LIST = "pedido/list";
    private static final String PEDIDO_BYID = "pedido/{id}";
    private static final String PEDIDO_CREATE = "pedido/create";
    private static final String PEDIDO_PUT = "pedido/modify";
    private static final String PEDIDO_DELETE = "pedido/delete/{id}";

    private static String MODEL_DELIVERY = "delivery";
    private static String MODEL_PEDIDO = "pedido";

    public DeliveryController(DeliveryAPI deliveryAPI) {
        this.deliveryAPI = deliveryAPI;
    }

    @GetMapping(DELIVERY_LIST)
    public String index(Model model) {
        List<Delivery> delivery = deliveryAPI.getDelivery();
        model.addAttribute("delivery", delivery);
        return DELIVERY_LIST;
    }

    @GetMapping(DELIVERY_BYID)
    public String delivery_byid(Model model, int id) {
        Delivery delivery = deliveryAPI.getDelivery(id);
        model.addAttribute("delivery", delivery);
        return DELIVERY_BYID;
    }

    @GetMapping(DELIVERY_CREATE)
    public String create_delivery(Model model) {
        model.addAttribute(MODEL_DELIVERY, new Delivery());
        return DELIVERY_CREATE;
    }

    @PostMapping(DELIVERY_CREATE)
    public String create_delivery(Model model, Delivery objDelivery, BindingResult result) {
        deliveryAPI.createDelivery(objDelivery);
        model.addAttribute("Delivery", objDelivery);
        model.addAttribute("mensaje", "Se registro con éxito");
        return DELIVERY_CREATE;
    }

    @DeleteMapping(DELIVERY_DELETE)
    public String delete_delivery(Model model, int id) {
        deliveryAPI.deleteDelivery(id);
        return DELIVERY_LIST;
    }

    @GetMapping(PEDIDO_LIST)
    public String list_pedido(Model model) {
        List<Pedido> pedido = deliveryAPI.getPedido();
        model.addAttribute("pedido", pedido);
        return PEDIDO_LIST;
    }

    @GetMapping(PEDIDO_BYID)
    public String pedido_byid(Model model, int id) {
        Pedido pedido = deliveryAPI.getPedido(id);
        model.addAttribute("pedido", pedido);
        return PEDIDO_BYID;
    }

    @GetMapping(PEDIDO_CREATE)
    public String create_pedido(Model model) {
        model.addAttribute(MODEL_DELIVERY, new Pedido());
        return PEDIDO_CREATE;
    }

    @PostMapping(PEDIDO_CREATE)
    public String create_pedido(Model model, Pedido objPedido, BindingResult result) {
        deliveryAPI.createPedido(objPedido);
        model.addAttribute("Pedido", objPedido);
        model.addAttribute("mensaje", "Se registro con éxito");
        return PEDIDO_CREATE;
    }

    @DeleteMapping(PEDIDO_DELETE)
    public String delete_pedido(Model model, int id) {
        deliveryAPI.deletePedido(id);
        return PEDIDO_DELETE;
    }
}
