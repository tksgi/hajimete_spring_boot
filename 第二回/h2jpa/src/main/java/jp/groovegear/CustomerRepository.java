package jp.groovegear;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  @Query("SELECT x FROM Customer x ORDER BY x. firstName, x. lastName")
  Page<Customer> findAllOderByName(Pageable pageable);
}
