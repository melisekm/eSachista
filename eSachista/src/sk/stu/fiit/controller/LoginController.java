package sk.stu.fiit.controller;

import sk.stu.fiit.controller.sevice.Service;
import sk.stu.fiit.validator.EntryValidator;
import sk.stu.fiit.view.LoginFrame;

/**
 * @see Controller
 * @author Martin Melisek
 */
public class LoginController {

    private EntryValidator validator;
    private Service service;

    public LoginController(LoginFrame view) {
        this.validator = new EntryValidator();
        this.service = new Service();
    }
    
    public boolean pripojitOrganizaciu(String adresa){
        return this.service.pripojOrganizaciu(adresa);
    }
    
    public String getOrgName(){
        return this.service.getLoggedIn().getNazov();
    }

    public void pripojitHraca(String adresa) {

    }

}
