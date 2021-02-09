package vita.all.web.dao;


import org.springframework.security.core.userdetails.UserDetails;
import vita.all.web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void add(User user);

    public void delete(Long id);

    public User update(Long id, User updatedUser);

    public User getUserByName(String s);
}
