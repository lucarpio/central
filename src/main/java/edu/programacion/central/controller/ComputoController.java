package edu.programacion.central.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.programacion.central.dto.Computo;
import edu.programacion.central.service.CRMService;
import edu.programacion.central.integration.api.ComputoAPI;

import javax.validation.Valid;

@Controller
public class ComputoController {

    private final ComputoAPI computoAPI;
    private static final String COMPUTO_CREATE = "computo/createComputo";
    private static final String COMPUTO_LIST = "computo/listComputo";
    private static String MODEL_COMPUTO = "computo";

    public ComputoController(ComputoAPI computoAPI) {
        this.computoAPI = computoAPI;
    }

    @GetMapping(COMPUTO_LIST)
    public String index(Model model) {
        List<Computo> computos = computoAPI.getComputos();
        model.addAttribute("computos", computos);
        return COMPUTO_LIST;
    }

    @GetMapping(COMPUTO_CREATE)
    public String create(Model model) {
        model.addAttribute(MODEL_COMPUTO, new Computo());
        return COMPUTO_CREATE;
    }

    @PostMapping(COMPUTO_CREATE)
    public String createSubmitForm(Model model, Computo objComp, BindingResult result) {
        if (result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro producto");
        } else {
            computoAPI.createComputo(objComp);
            model.addAttribute(MODEL_COMPUTO, objComp);
            model.addAttribute("mensaje", "Se registro producto");
        }
        return COMPUTO_CREATE;
    }
}