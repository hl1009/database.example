package de.ehex.database.example.relationaldataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerRespository customerrespository;
    @GetMapping("/ausgabe")
    public String ausgabe(Model model) {
        List<Customer> customers= customerrespository.loadCustomerFromDb();
        model.addAttribute("customers",customers);
        return "ausgabe";
    }
}