package br.com.appcinemateca.api.services.interfaces;


import br.com.appcinemateca.api.domain.User;
import br.com.appcinemateca.api.dto.UserDTO;

import java.util.List;

public interface UserServices {

    User findById(Long id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Long id);


}
