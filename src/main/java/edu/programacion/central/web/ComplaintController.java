package edu.programacion.central.web;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

import edu.programacion.central.dto.Complaint;

import edu.programacion.central.service.CRMService;


@Controller
public class ComplaintController {

    private final CRMService crmService;
    private static final String COMPLAINT_LIST ="complaint/listComplaint"; 

    public ComplaintController(CRMService crmService) {
        this.crmService = crmService;
    }

    @GetMapping(COMPLAINT_LIST)
    public String index(Model model) {
        List<Complaint> complaints = crmService.getValidComplaints();
        model.addAttribute("complaints", complaints);
        return COMPLAINT_LIST;
    }
}
