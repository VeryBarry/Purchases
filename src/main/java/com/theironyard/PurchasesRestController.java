package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by VeryBarry on 11/1/16.
 */
@RestController
public class PurchasesRestController {
    @Autowired
    PurchaseRepository purchasesrep;

    @Autowired
    CustomerRepository customersrep;

    String purchases = "purchases.txt";
    String customers = "customers.txt";

    @PostConstruct
    public void init() {
        Scanner filescanner = new Scanner(System.in);
        ArrayList<Customer> customerArray = new ArrayList<>();
        if (customersrep.count() == 0) {
            File file = new File(customers);
            while (filescanner.hasNext()) {
                String input = filescanner.nextLine();
                String[] sep = input.split(",");
                Customer customer = new Customer(sep[0], sep[1]);
                customersrep.save(customer);
            }


        }
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public
}
