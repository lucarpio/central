package edu.programacion.central.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import edu.programacion.central.dto.Ropa;
//import edu.programacion.central.dto.TipoRopa;
import edu.programacion.central.service.ROPAService;

@Controller
public class RopaController {

    private final ROPAService ropaService;
    private static final String ROPA_LIST = "ropa/listRopa";
    // private static String MODEL_ROPA = "ropa";

    public RopaController(ROPAService ropaService) {
        this.ropaService = ropaService;
    }

    @GetMapping(ROPA_LIST)
    public String index(Model model) {
        List<Ropa> ropas = ropaService.getValidRopas();
        model.addAttribute("ropas", ropas);
        return ROPA_LIST;
    }

}
