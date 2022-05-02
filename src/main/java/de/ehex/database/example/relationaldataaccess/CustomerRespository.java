package de.ehex.database.example.relationaldataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Customer> loadCustomerFromDb(){
       List<Customer> customers =  jdbcTemplate.query(
                "SELECT id, first_name, last_name, geburts_datum FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("geburts_datum"))
        ).stream().toList();
       return customers;
    }
}


