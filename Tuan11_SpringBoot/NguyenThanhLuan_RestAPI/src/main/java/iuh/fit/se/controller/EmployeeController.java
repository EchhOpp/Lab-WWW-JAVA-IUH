package iuh.fit.se.controller;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, Object>> saveEmployee(@Valid @RequestBody Employee employee,
        BindingResult bindingResult) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<String, Object>();
            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("message", bindingResult.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", HttpStatus.OK.value());
            response.put("data", employeeService.save(employee));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> updateObject(@PathVariable int id, @Valid @RequestBody Employee employee, BindingResult bindingResult) {
        Map<String, Object> reponse = new LinkedHashMap<String, Object>();
        if(bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<String, Object>();
            bindingResult.getFieldErrors().stream().forEach(
                    result -> {
                        errors.put(result.getField(), result.getDefaultMessage());
                    }
            );
            reponse.put("state", HttpStatus.BAD_REQUEST.value());
            reponse.put("error", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reponse);
        } else {
            reponse.put("status", HttpStatus.OK.value());
            reponse.put("data", employeeService.update(id, employee));
            return  ResponseEntity.status(HttpStatus.OK.value()).body(reponse);
        }

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.delete(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getEmployees(@RequestParam(required = false) String keyword) {

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());

        if (keyword == null || keyword.isEmpty()) {
            response.put("data", employeeService.findAll());
        }
        else {
            response.put("data", employeeService.search(keyword));
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
