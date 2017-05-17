package fcicio.mainservice.service;

import fcicio.chatapp.messageservice.model.RoomEntity;
import fcicio.chatapp.messageservice.service.IFeignMessageServiceEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestEndpoint {
    @Autowired
    private IFeignMessageServiceEndpoint serviceEndpoint;

    @RequestMapping(method = RequestMethod.GET)
    public List<RoomEntity> getAllRooms(){
        return serviceEndpoint.getAllRooms();
    }
}
