package com.businessworkframe;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    @GetMapping(path = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHallo(){
        return "Hello ihr da";
    }
}

