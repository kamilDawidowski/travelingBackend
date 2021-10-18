package wat.dawidowski.project.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    @PostMapping
    public String registration(@RequestBody RegistrationRequest form)
    {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return  registrationService.register(form);
    }
    @GetMapping(path = "confirm")
    public String registration2()
    {
        return  "ss";
    }
//    @GetMapping(path = "confirm")
//    public String confirm(@RequestParam("token") String token) {
//        return registrationService.confirmToken(token);
//    }


}
