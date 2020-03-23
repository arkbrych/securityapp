package pl.brych.securityapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.brych.securityapp.service.ActiveUserStore;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AppController {

    @Autowired
    ActiveUserStore activeUserStore;

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal) {
        return "Cześć admin " + principal.getName();
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal) {
        return "Cześć user " + principal.getName();
    }

    @GetMapping("/forAll")
    public String forAll(Principal principal) {
        if (principal == null) {
            return "Czesć nieznajomy ";
        } else
            return "Cześć " + principal.getName();
    }

    @GetMapping("/goodbye")
    public String logout() {
        return "Papa";
    }
}
