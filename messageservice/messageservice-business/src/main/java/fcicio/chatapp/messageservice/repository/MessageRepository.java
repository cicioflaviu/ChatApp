package main.java.fcicio.chatapp.messageservice.repository;

import main.java.fcicio.chatapp.messageservice.service.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long>{
}
