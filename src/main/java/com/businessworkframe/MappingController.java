package com.businessworkframe;

import com.businessworkframe.db.crm.CRMDbImpl;
import com.businessworkframe.pages.dashboard.NewCostumerDisplay;
import com.businessworkframe.db.user.Auth;
import com.businessworkframe.db.user.Login;
import com.businessworkframe.db.user.LoginImpl;
import com.businessworkframe.model.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    CRMDbImpl crmDb = new CRMDbImpl();

    @GetMapping(path = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHallo(){
        return "Hello ihr da";
    }

    //Authentifizierung & Autorisierung

    @PostMapping(
            path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Auth login(@RequestBody User user) throws UnsupportedEncodingException, UnirestException {
        Login login = new LoginImpl();
        return login.login(user);
    }

    @PostMapping(
            path = "/logout",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Boolean logout(@RequestBody Auth auth) throws UnirestException {
        Login login = new LoginImpl();
        return login.logout(auth);
    }

    @PostMapping(
            path = "/isAuthorized ",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Boolean isAuthorized(@RequestBody Auth auth) throws UnirestException, UnsupportedEncodingException {
        Login login = new LoginImpl();
        return login.isAuthorized(auth);
    }

    //Dashboard

    @GetMapping(path = "/dashboard/newCostumer/{startDisplay}/{endDisplay}")
    @ResponseStatus(HttpStatus.OK)
    public NewCostumerDisplay getNewCustomerDisplay( @PathVariable String startDisplay,@PathVariable String endDisplay) throws UnirestException, UnsupportedEncodingException {
        return crmDb.getNewCostumerDisplay( startDisplay,endDisplay);
    }

}

