package fcicio.chatapp.userservice.service;

import fcicio.chatapp.userservice.model.UserEntity;
import fcicio.chatapp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint implements IFeignUserEndpoint {

    @Autowired
    UserRepository repository;

    @Override
    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserEntity saveUser(@RequestBody UserEntity user) {
        if(user.getUsername() == null){
            user.setUsername(user.getEmail());
        }
        return repository.save(user);
    }
}
