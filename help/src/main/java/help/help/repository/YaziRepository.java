package help.help.repository;

import help.help.module.Yazi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YaziRepository extends JpaRepository<Yazi,Long> {

}
