package fantastticfour.src.main.java.use_case.login;

import fantastticfour.src.main.java.entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
