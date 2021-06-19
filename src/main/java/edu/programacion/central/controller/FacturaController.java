package edu.programacion.central.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.programacion.central.dto.Factura;
import edu.programacion.central.integration.SunatAPI;

public class FacturaController {
    private final SunatAPI sunatAPI;
    private static final String FACTURA_LIST = "factura/list";
    private static final String FACTURA_BYID = "factura/{id}";
    private static final String FACTURA_CREATE = "factura/create";
    private static final String FACTURA_PUT = "factura/modify";
    private static final String FACTURA_DELETE = "factura/delete/{id}";

    private static String MODEL_FACTURA = "factura";

    public FacturaController(SunatAPI sunatAPI) {
        this.sunatAPI = sunatAPI;
    }

    @GetMapping(FACTURA_LIST)
    public String index(Model model) {
        List<Factura> factura = sunatAPI.getFactura();
        model.addAttribute("factura", factura);
        return FACTURA_LIST;
    }

    @GetMapping(FACTURA_BYID)
    public String Factura_byid(Model model, int id) {
        Factura factura = sunatAPI.getFactura(id);
        model.addAttribute("factura", factura);
        return FACTURA_BYID;
    }

    @GetMapping(FACTURA_CREATE)
    public String create_Factura(Model model) {
        model.addAttribute(MODEL_FACTURA, new Factura());
        return FACTURA_CREATE;
    }

    @PostMapping(FACTURA_CREATE)
    public String create_Factura(Model model, Factura objFactura, BindingResult result) {
        sunatAPI.createFactura(objFactura);
        model.addAttribute("factura", objFactura);
        model.addAttribute("mensaje", "Se registro con éxito");
        return FACTURA_CREATE;
    }

    @DeleteMapping(FACTURA_DELETE)
    public String delete_Factura(Model model, int id) {
        sunatAPI.deleteFactura(id);
        return FACTURA_DELETE;
    }
}
