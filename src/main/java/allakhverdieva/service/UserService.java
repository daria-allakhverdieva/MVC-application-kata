package allakhverdieva.service;

import allakhverdieva.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
