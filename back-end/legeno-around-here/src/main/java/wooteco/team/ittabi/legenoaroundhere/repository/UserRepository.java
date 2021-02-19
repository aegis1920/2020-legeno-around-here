package wooteco.team.ittabi.legenoaroundhere.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wooteco.team.ittabi.legenoaroundhere.domain.user.Email;
import wooteco.team.ittabi.legenoaroundhere.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(Email email);

    @Query("select distinct u from User u left join fetch u.image left join fetch u.roles where u.email = :email")
    Optional<User> findByEmailWithUserImageAndRolesByJoinFetch(@Param("email") Email email);
}
