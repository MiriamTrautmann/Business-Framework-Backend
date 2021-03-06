package com.businessframework;

import com.businessframework.db.crm.CRMDb;
import com.businessframework.db.crm.CRMDbImpl;
import com.businessframework.db.employee.EmployeeDb;
import com.businessframework.db.employee.EmployeeImpl;
import com.businessframework.db.financials.InvoiceDB;
import com.businessframework.db.financials.InvoiceImpl;
import com.businessframework.db.tickets.TicketDb;
import com.businessframework.db.tickets.TicketDbImpl;
import com.businessframework.pages.dashboard.InvoiceDisplay;
import com.businessframework.pages.dashboard.NewCostumerDisplay;
import com.businessframework.db.user.Auth;
import com.businessframework.db.user.Login;
import com.businessframework.db.user.LoginImpl;
import com.businessframework.models.User;
import com.businessframework.pages.dashboard.TicketDisplay;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Der MappingController ist der RestController der Spring-Application. Hier werden die vom Client verfügbaren
 * HTTP-Schnittstellen mit der dazugehörigen Methode definiert.
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MappingController {

    /**
     * Die Datenbankimplementierungen sind instanziiert.
     */

    CRMDb crmDb = new CRMDbImpl();
    TicketDb ticketDb = new TicketDbImpl();
    InvoiceDB invoiceDB = new InvoiceImpl();
    EmployeeDb employeeDb = new EmployeeImpl();

    //Authentifizierung & Autorisierung

    /**
     * Schnittstelle, die das Login (Authentifizierung) bereitstellt.
     *
     * @param user Authentifizierungsinformationen zum User bestehend aus E-Mail und Passwort
     * @see User
     * @return Auth: ein Auth-Objekt mit allen Authentifizierungsdaten wird zurückgegeben.
     * @see Auth
     * @throws UnsupportedEncodingException
     * @throws UnirestException
     */

    @PostMapping(
            path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Auth login(@RequestBody User user) throws UnsupportedEncodingException, UnirestException {
        Login login = new LoginImpl();
        return login.login(user);
    }

    /**
     * Schnittstelle, die den User abmeldet
     *
     * @param auth Übergibt die Authentifizierungsdaten (E-Mail, aktueller Token)
     * @return Boolean: Gibt zurück, ob das Logout funktioniert hat
     * @throws UnirestException
     */
    @PostMapping(
            path = "/logout",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public Boolean logout(@RequestBody Auth auth) throws UnirestException {
        Login login = new LoginImpl();
        return login.logout(auth);
    }

    /**
     * Schnittstelle, die die Autorisierung bzw. den Token überprüft.
     *
     * @param auth Übergibt die aktuellen Authentifizierungsdaten
     * @return Boolean: Gibt zurück, ob der User noch authentifiziert ist.
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
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

    /**
     * Schnittstelle, die die Daten zum Frontend-Display für die neuen Kunden liefert.
     *
     * @return NewCustomerDisplay: Gibt das entsprechende Display-Objekt für die neuen Kunden zurück
     * @see NewCostumerDisplay
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
    @GetMapping(path = "/dashboard/newCostumer")
    @ResponseStatus(HttpStatus.OK)
    public NewCostumerDisplay getNewCustomerDisplay() throws UnirestException, UnsupportedEncodingException {
        return crmDb.getNewCostumerDisplay();
    }

    /**
     * Schnittstelle, die die Informationen des Ticket-Display an das Frontend bereitstellt.
     *
     * @return TicketDisplay: Gibt das TicketDisplay-Objekt zurück
     * @see TicketDisplay
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */

    @GetMapping(path = "/dashboard/TicketsAvg")
    @ResponseStatus(HttpStatus.OK)
    public TicketDisplay getTicketDisplayAvg() throws UnirestException, UnsupportedEncodingException {
        return ticketDb.getAvgTickets();
    }

    /**
     * Schnittstelle, die Informationen über neue Tickets bereitstellt.
     *
     * @return TicketDisplay: Gibt das TicketDisplay-Objekt zurück
     * @see TicketDisplay
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
    @GetMapping(path = "/dashboard/NewTicket")
    @ResponseStatus(HttpStatus.OK)
    public TicketDisplay getTicketDisplayNew() throws UnirestException, UnsupportedEncodingException {
        return ticketDb.getNewTickets();
    }

    /**
     * Schnittstelle, die Informationen über Rechnungen für das Frontend bereitstellt.
     *
     * @return InvoiceDisplay: Gibt das InvoiceDisplay-Objekt zurück
     * @see InvoiceDisplay
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */

    @GetMapping(path = "/dashboard/InvoiceDisplay")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceDisplay getInvoiceDisplay() throws UnirestException, UnsupportedEncodingException {
        return invoiceDB.getInvoiceDisplay();
    }

    /**
     * Schnittstelle, die Informationen über den Mitarbeiteranstieg für ein Diagramm liefert.
     *
     * @return HashMap: GIbt eine Hashmap für die Diagramm-Darstellung zurück
     * @throws UnirestException
     * @throws UnsupportedEncodingException
     */
    @GetMapping(path = "/dashboard/EmployeeIncrease")
    @ResponseStatus(HttpStatus.OK)
    public HashMap getEmployeeIncrease() throws UnirestException, UnsupportedEncodingException {
        return employeeDb.getEmployeePerApartment();
    }

}

