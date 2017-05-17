package main.java.fcicio.chatapp.messageservice.service;

import main.java.fcicio.chatapp.messageservice.model.RoomEntity;
import main.java.fcicio.chatapp.messageservice.model.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@FeignClient("message-service")
public interface IFeignMessageServiceEndpoint {

    @RequestMapping(value = "/room/init", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Set<RoomEntity> initRoom(@RequestBody UserEntity user, @RequestParam String name);

    @RequestMapping(value = "/room", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<RoomEntity> getAllRooms();

    @RequestMapping(value = "/room", method = RequestMethod.DELETE)
    void deleteRoom(@RequestParam long roomId);

    @RequestMapping(value = "/room/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Set<UserEntity> connectedUsersForSpecificRoom(@RequestParam long roomId);

    @RequestMapping(value = "room/disconnect", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void disconnectUserFromRoom(@RequestParam String username, @RequestParam long roomId);

    @RequestMapping(value = "room/connect", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void connectUserToRoom(@RequestBody UserEntity user, @RequestParam long roomId);

}
