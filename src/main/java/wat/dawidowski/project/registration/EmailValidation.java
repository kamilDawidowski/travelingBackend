package wat.dawidowski.project.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidation implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO:Email Validation
        return true;
    }
}
