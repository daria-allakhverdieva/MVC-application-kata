package allakhverdieva.dao;

import allakhverdieva.model.User;
import java.util.List;

public interface UserDao {
    List<User> usersList();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
