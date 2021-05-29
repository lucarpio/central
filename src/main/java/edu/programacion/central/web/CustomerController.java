package edu.programacion.central.web;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.programacion.central.dto.Customer;
import edu.programacion.central.service.CRMService;

import org.springframework.validation.BindingResult;

@Controller
public class CustomerController {
    
    private final CRMService crmService;
    private static final String CUSTOMER_CREATE = "customer/createcustomer";
    private static final String CUSTOMER_LIST ="customer/listCustomer"; 
    private static String MODEL_CUSTOMER="customer";

    public CustomerController(CRMService crmService) {
        this.crmService = crmService;
    }

    @GetMapping(CUSTOMER_LIST)
    public String index(Model model) {
        List<Customer> customers = crmService.getValidCustomers();
        model.addAttribute("customers", customers);
        return CUSTOMER_LIST;
    }

    @GetMapping(CUSTOMER_CREATE)
    public String create(Model model) {
        model.addAttribute(MODEL_CUSTOMER, new Customer());
        return CUSTOMER_CREATE;
    }    

    @PostMapping(CUSTOMER_CREATE)
    public String createSubmitForm(Model model, 
        Customer objCus, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro empleado");
        }else{
            crmService.addValidCustomer(objCus);
            model.addAttribute(MODEL_CUSTOMER, objCus);
            model.addAttribute("mensaje", "Se registro empleado");
        }
        return CUSTOMER_CREATE;
    }
}
