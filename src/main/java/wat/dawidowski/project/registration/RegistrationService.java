package wat.dawidowski.project.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wat.dawidowski.project.appuser.AppUser;
import wat.dawidowski.project.appuser.AppUserRole;
import wat.dawidowski.project.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidation emailValidation;
    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {
        boolean isValidEmail =emailValidation.test(request.getEmail());
        if(!isValidEmail)
        {
            throw new IllegalStateException("email is incorrect !");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
    }
}
