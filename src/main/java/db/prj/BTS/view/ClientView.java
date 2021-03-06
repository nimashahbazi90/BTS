package db.prj.BTS.view;

import db.prj.BTS.domain.Client;
import db.prj.BTS.service.ClientService;
import db.prj.BTS.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Named
public class ClientView {


    @Autowired
    ClientService clientService;

    @Autowired
    LevelService levelService;
    private String firstname;
    private String lastname;
    private String phone_num;
    private String cellphone_num;
    private String email;
    private String street;
    private String state;
    private String city;
    private String zipcode;
    private String fiat_currency;
    private String bitcoin_bal;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    private String level;
    List<Client> clients;

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getCellphone_num() {
        return cellphone_num;
    }

    public void setCellphone_num(String cellphone_num) {
        this.cellphone_num = cellphone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFiat_currency() {
        return fiat_currency;
    }

    public void setFiat_currency(String fiat_currency) {
        this.fiat_currency = fiat_currency;
    }

    public String getBitcoin_bal() {
        return bitcoin_bal;
    }

    public void setBitcoin_bal(String bitcoin_bal) {
        this.bitcoin_bal = bitcoin_bal;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    public String searchClients() {

        Client filter = new Client();
        filter.setFirstname(firstname);
        filter.setLastname(lastname);
        filter.setStreet(street);
        filter.setCity(city);
        filter.setState(state);
        filter.setZipcode(zipcode);
        try {
            filter.setBitcoin_bal(Double.parseDouble(bitcoin_bal));
            filter.setFiat_currency(Double.parseDouble(fiat_currency));
        } catch (Exception e) {
        }
        filter.setCellphone_num(cellphone_num);
        filter.setPhone_num(phone_num);

        filter.setLevel(levelService.getByName(level));
        filter.setEmail(email);

        clients = clientService.retrieveClient(filter);
        if (clients.size() != 0) {
            return "search_result.xhtml";
        } else {
            return "no_result.xhtml";
        }
    }

    public Client getClient() {
        return clientService.getClient();
    }

    public String round(double val) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(val);
    }

    public String round(String val) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(Double.parseDouble(val));
    }

    public String showKeyword() {
        String val = "";
        if (firstname != null && !firstname.isEmpty()) {
            val = val + firstname;
        }
        if (lastname != null && !lastname.isEmpty()) {
            val = val +"+"+ lastname;
        }
        if (cellphone_num != null && !cellphone_num.isEmpty()) {
            val = val + cellphone_num;
        }
        if (phone_num != null && !phone_num.isEmpty()) {
            val = val +"+"+ phone_num;
        }
        if (email != null && !email.isEmpty()) {
            val = val +"+"+ email;
        }
        if (street != null && !street.isEmpty()) {
            val = val +"+"+ street;
        }
        if (state != null && !state.isEmpty()) {
            val = val +"+"+ state;
        }
        if (zipcode != null && !zipcode.isEmpty()) {
            val = val +"+"+ zipcode;
        }
        if (city != null && !city.isEmpty()) {
            val = val +"+"+ city;
        }
        if (bitcoin_bal != null && !bitcoin_bal.isEmpty()) {
            val = val +"+"+ bitcoin_bal;
        }
        if (fiat_currency != null && !fiat_currency.isEmpty()) {
            val = val +"+"+ fiat_currency;
        }
        if (level != null && !level.isEmpty()) {
            val = val +"+"+ level;
        }
        return val;
    }
}
