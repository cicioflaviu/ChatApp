package main.java.fcicio.chatapp.messageservice.repository;

import main.java.fcicio.chatapp.messageservice.service.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    @Override
    void delete(Long aLong);
}
