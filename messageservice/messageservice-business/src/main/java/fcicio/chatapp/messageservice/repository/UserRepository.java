package main.java.fcicio.chatapp.messageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
