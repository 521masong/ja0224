package io.cjf.jcartstoreback.controller;

import io.cjf.jcartstoreback.dto.in.OrderSearchInDTO;
import io.cjf.jcartstoreback.dto.out.OrderHistoryListOutDTO;
import io.cjf.jcartstoreback.dto.out.OrderListOutDTO;
import io.cjf.jcartstoreback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(List<OrderSearchInDTO> OrderSearchInDTO, Integer orderId){
        return null;
    }


    @GetMapping("/getMyorderlist")
    public PageOutDTO<OrderListOutDTO> getMyorderlist(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                     Integer orderId){
        return null;
    }


    @GetMapping("/getById")
    public OrderHistoryListOutDTO getById(@RequestParam Integer orderId){
        return null;
    }
}
