package main.java.fcicio.chatapp.messageservice.service;

import main.java.fcicio.chatapp.messageservice.model.RoomEntity;
import main.java.fcicio.chatapp.messageservice.model.UserEntity;
import fcicio.chatapp.messageservice.repository.RoomRepository;
import fcicio.chatapp.messageservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Transactional
public class MessageServiceEndpoint implements IFeignMessageServiceEndpoint {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<RoomEntity> initRoom(@RequestBody UserEntity user, @RequestParam String name) {
        UserEntity repoUser =  userRepository.findOne(user.getUsername());
        if(repoUser != null){
           return repoUser.addRoom(new RoomEntity(name, new HashSet<>()));

        }
        Set<RoomEntity> rooms = user.addRoom(new RoomEntity(name, new HashSet<>()));
        userRepository.save(user);
        return rooms;
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteRoom(@RequestParam long roomId) {
        roomRepository.delete(roomId);
    }

    @Override
    public Set<UserEntity> connectedUsersForSpecificRoom(@RequestParam long roomId) {
        return roomRepository.getOne(roomId).getUsers();
    }

    @Override
    public void disconnectUserFromRoom(@RequestParam String username, @RequestParam long roomId) {
        UserEntity user = userRepository.findOne(username);
        user.removeRoom(roomId);
    }

    @Override
    public void connectUserToRoom(@RequestBody UserEntity user, @RequestParam long roomId) {
        UserEntity repoUser =  userRepository.findOne(user.getUsername());
        RoomEntity roomEntity = roomRepository.findOne(roomId);
        if(repoUser != null && roomEntity != null){
            repoUser.addRoom(roomEntity);
        }
        else if(roomEntity != null){
            user.addRoom(roomEntity);
            userRepository.save(user);
        }
        //TODO:Raise exception if room doesn't exist
    }
}
