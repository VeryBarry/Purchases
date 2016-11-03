package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by VeryBarry on 11/1/16.
 */
@Controller
public class PurchasesController {
    @Autowired
    PurchaseRepository purchasesrep;

    @Autowired
    CustomerRepository customersrep;

    String purchases = "purchases.txt";
    String customers = "customers.txt";

    @PostConstruct
    public void init() {
        if (customersrep.count() == 0) {
            File file = new File(customers);
            Scanner fileScanner;
            try {
                fileScanner = new Scanner(file);
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    String[] sep = line.split(",");
                    Customer customer = new Customer(sep[0], sep[1]);
                    customersrep.save(customer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (purchasesrep.count() == 0) {
            File file2 = new File(purchases);
            Scanner fileScanner2;
            try {
                fileScanner2 = new Scanner(file2);
                while (fileScanner2.hasNext()) {
                    String line = fileScanner2.nextLine();
                    String[] sep = line.split(",");
                    String date = sep[1];
                    String creditCard = sep[2];
                    int cvv = Integer.valueOf(sep[3]);
                    String category = sep[4];
                    Purchase purchase = new Purchase(date, creditCard, cvv, category, customersrep.findOne(Integer.valueOf(sep[0])));
                    purchasesrep.save(purchase);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        List<Purchase> purchaseList;
        if(category != null) {
            purchaseList = purchasesrep.findByCategory(category);
        }
        else {
            purchaseList = (List<Purchase>) purchasesrep.findAll();
        }
        model.addAttribute("purchases", purchaseList);
        return "home";
    }
}