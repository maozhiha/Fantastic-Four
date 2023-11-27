package fantastticfour.src.main.java.use_case.signup;

import fantastticfour.src.main.java.entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
