package net.javaguides.springboot.repository;

import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import net.javaguides.springboot.entity.Group;
import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

//@Query("select g from Group g join g.user_groups u where u.userId = :userId")
//List<Group> findAllByUsers(User user);

    //"select u.user_name, g.group_name, e.transaction_id, g.group_id, e.amount from  User u left join u.groups ong left join g.group_expenses e where u.userId = :userId"
    @Query(nativeQuery=  true, value="select ug.group_id, e.transaction_id from expenses e left join user_groups ug on e.group_group_id = ug.group_id left join users u on ug.user_id = u.user_id left join (select distinct u.user_name) on where u.user_id = :userId")
    List<Object> findAllByUserId(@Param("userId") Long userId);

    @Query("select sum(e.amount) from User u join u.groups g join g.group_expenses e where e.to_userId = :userId and e.settled = 'N'")
    Double getbalance(@Param("userId") Long userId);

}
