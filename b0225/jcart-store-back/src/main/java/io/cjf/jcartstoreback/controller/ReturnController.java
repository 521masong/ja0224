package io.cjf.jcartstoreback.controller;


import io.cjf.jcartstoreback.dto.out.PageOutDTO;
import io.cjf.jcartstoreback.dto.out.ReturnListOutDTO;
import io.cjf.jcartstoreback.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class ReturnController {
    @GetMapping("/getreturnId")
    public PageOutDTO<ReturnListOutDTO> getreturnId(@RequestParam Integer pageNum,
                                                    Integer returnId){
        return null;
    }
    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }
}
