package edu.programacion.central.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import edu.programacion.central.dto.Employee;
import edu.programacion.central.service.GDHService;

@Controller

public class EmployeeController {

    private final GDHService gdhService;
    private static final String EMPLOYEE_INDEX = "employee/index";


    public EmployeeController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping(EMPLOYEE_INDEX)
    public String index(Model model) {
        List<Employee> employess = gdhService.queryEmployeeExternal();
        model.addAttribute("employees", employess);
        return EMPLOYEE_INDEX;
    }

}
