package de.ehex.database.example.relationaldataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerRespository customerrespository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/ausgabe")
    public String ausgabe(Model model) {
        List<Customer> customers = customerrespository.loadCustomerFromDb();
        model.addAttribute("customers", customers);
        return "ausgabe";
    }
    @GetMapping("/eingabe")
    public String eingabe(Model model) {
        Customer customer = new Customer(0 , "Vorname" , "nasd", "gb");
        model.addAttribute("customer", customer);
        return "eingabe";
    }

        @PostMapping("/eingabe")
        public String eingabe(@ModelAttribute Customer customer, Model model) {
            List<Customer> customers = customerrespository.loadCustomerFromDb();
            customers.add(customer);
            model.addAttribute("customer", customer);
            return "ausgabe";
    }
    @RequestMapping(value = "/Customer", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("ausgabe", "Customer", new Employee());
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String submit(@ModelAttribute("customer")Customer customer,
                         BindingResult result, ModelMap model) {
        model.addAttribute("first_name", customer.getFirstName());
        model.addAttribute("last_name", customer.getLastName());
        model.addAttribute("geburtsdatum", customer.getGeburtsDatum());
        jdbcTemplate.update("INSERT INTO customers  ( first_name, last_name, geburts_datum ) Values(?,?,?) ",customer.getFirstName(),customer.getLastName(),customer.getGeburtsDatum());
        return "ausgabe";
    }
}