package fcicio.chatapp.userservice.service;

import fcicio.chatapp.userservice.model.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("user")
public interface IFeignUserEndpoint {
    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    List<UserEntity> getAllUsers();

    @RequestMapping(method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    UserEntity saveUser(UserEntity user);

}
