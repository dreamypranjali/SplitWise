package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Group;
import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /*@Query("select g from Group g join g.user_groups u where u.userId = :userId")
    List<Group> findAllByUserId(@Param("userId") String userId);*/

    //List<Group> findAllByUserId(Long userId);


}
