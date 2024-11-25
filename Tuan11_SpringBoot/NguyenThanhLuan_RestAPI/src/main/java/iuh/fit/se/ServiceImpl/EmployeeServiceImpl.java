package iuh.fit.se.ServiceImpl;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.handlerexception.ItemNotFoundException;
import iuh.fit.se.repository.EmployeeRepository;
import iuh.fit.se.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Can not find Employee with id: " + id));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) {
        this.findById(id);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean delete(int id) {
        Employee employee = this.findById(id);
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public List<Employee> search(String keyword) {
        return employeeRepository.search(keyword);
    }
}
