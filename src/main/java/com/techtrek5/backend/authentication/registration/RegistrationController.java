package com.techtrek5.backend.authentication.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {
    private RegistrationService registrationService;

    @PostMapping(path = "/register")
    public String register(@RequestBody RegistrationModel registrationModel){
        return registrationService.register(registrationModel);
    }

    @GetMapping(path = "/confirm")
    public RedirectView confirm(@RequestParam("token") String token){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/login");
        String result = registrationService.confirmToken(token);
        if(result.equals("confirmed"))
            return redirectView;
        else{
            redirectView.setUrl("http://localhost:8080/error");
            return redirectView;
        }
    }
}
