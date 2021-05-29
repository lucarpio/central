package edu.programacion.central.service;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import edu.programacion.central.dto.Customer;
import edu.programacion.central.dto.Complaint;
import edu.programacion.central.integration.api.CRMAPI;

@Service
public class CRMService {

    private CRMAPI crmAPI;

    public CRMService(CRMAPI crmAPI){
        this.crmAPI = crmAPI;
    }

    public List<Customer> getValidCustomers(){
        List<Customer> customersValid = crmAPI.getCustomers().stream().collect(Collectors.toList());
        return customersValid;
    }

    public List<Complaint> getValidComplaints(){
        List<Complaint> complaintsValid = crmAPI.getComplaints().stream().collect(Collectors.toList());
        return complaintsValid;
    }

    
    public void addValidCustomer(Customer e){
        if(!e.getName().equals("A")){
            crmAPI.postCustomers(e);
        }
    }
    
}
