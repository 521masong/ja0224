package io.cjf.jcartadministrationback.controller;


import io.cjf.jcartadministrationback.dto.in.AdministratorLoginOutDTO;
import io.cjf.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import io.cjf.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import io.cjf.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdministratorLoginOutDTO administratorLoginOutDTO) {
        return null;
    }


    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestAttribute Integer administratorId) {

        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum) {
        return null;
    }

    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(Integer administratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO) {

    }

}
