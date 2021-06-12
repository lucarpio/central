package edu.programacion.central.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import edu.programacion.central.dto.Complaint;

import edu.programacion.central.service.CRMService;

@Controller
public class ComplaintController {

    private final CRMService crmService;
    private static final String COMPLAINT_LIST = "complaint/listComplaint";
    private static final String COMPLAINT_CREATE = "complaint/createComplaint";

    public ComplaintController(CRMService crmService) {
        this.crmService = crmService;
    }

    @GetMapping(COMPLAINT_LIST)
    public String index(Model model) {
        List<Complaint> complaints = crmService.getValidComplaints();
        model.addAttribute("complaints", complaints);
        return COMPLAINT_LIST;
    }

    @GetMapping(COMPLAINT_CREATE)
    public String create(Model model) {
        model.addAttribute("complaint", new Complaint());
        return COMPLAINT_CREATE;
    }

    @PostMapping(COMPLAINT_CREATE)
    public String createForm(Model model, 
        Complaint objComp, BindingResult result) {
        
            crmService.addComplaint(objComp);
            model.addAttribute("complaint", objComp);
            model.addAttribute("mensaje", "Se registro con éxito");
        
        return COMPLAINT_CREATE;
    }

}
