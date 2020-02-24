package io.cjf.jcartadministrationback.controller;

import io.cjf.jcartadministrationback.dto.out.CustomerListOutDTO;
import io.cjf.jcartadministrationback.dto.out.CustomerShowOutDTO;
import io.cjf.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(){

        return null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

}
