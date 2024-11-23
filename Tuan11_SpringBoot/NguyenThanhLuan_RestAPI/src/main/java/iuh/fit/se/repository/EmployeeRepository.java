package iuh.fit.se.repository;

import iuh.fit.se.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e FROM Employee e WHERE e.firstName LIKE %:keyword%"
            + " OR e.lastName LIKE %:keyword%"
            + " OR e.emailAddress LIKE %:keyword%"
            + " OR e.phoneNumber LIKE %:keyword%")
    List<Employee> search(@Param("keyword") String keyword);
}
