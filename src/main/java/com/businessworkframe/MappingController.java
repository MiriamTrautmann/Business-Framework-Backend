package com.businessworkframe;

import com.businessworkframe.db.crm.CRMDb;
import com.businessworkframe.db.crm.CRMDbImpl;
import com.businessworkframe.db.financials.InvoiceDB;
import com.businessworkframe.db.financials.InvoiceImpl;
import com.businessworkframe.db.tickets.TicketDb;
import com.businessworkframe.db.tickets.TicketDbImpl;
import com.businessworkframe.pages.dashboard.InvoiceDisplay;
import com.businessworkframe.pages.dashboard.NewCostumerDisplay;
import com.businessworkframe.db.user.Auth;
import com.businessworkframe.db.user.Login;
import com.businessworkframe.db.user.LoginImpl;
import com.businessworkframe.model.User;
import com.businessworkframe.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    CRMDb crmDb = new CRMDbImpl();
    TicketDb ticketDb = new TicketDbImpl();
    InvoiceDB invoiceDB = new InvoiceImpl();

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

    @GetMapping(path = "/dashboard/TicketsAvg")
    @ResponseStatus(HttpStatus.OK)
    public TicketDisplay getTicketDisplayAvg() throws UnirestException, UnsupportedEncodingException {
        return ticketDb.getAvgTickets();
    }

    @GetMapping(path = "/dashboard/NewTicket")
    @ResponseStatus(HttpStatus.OK)
    public TicketDisplay getTicketDisplayNew() throws UnirestException, UnsupportedEncodingException {
        return ticketDb.getNewTickets();
    }

    @GetMapping(path = "/dashboard/InvoiceDisplay")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceDisplay getInvoiceDisplay() throws UnirestException, UnsupportedEncodingException {
        return invoiceDB.getInvoiceDisplay();
    }


}

