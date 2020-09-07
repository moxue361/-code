package tao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tao.mapper.EmployeeMapper;
import tao.model.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee doLogin(Employee employee) {
        return employeeMapper.queryEmployee(employee);
    }
    
    public Integer addEmployee(Employee employee) {
        employee.setStatus(0);
        employee.setRole("2");
        if(employeeMapper.queryEmployeeByUsername(employee.getUsername())!=null){
            return 0;
        }
        return employeeMapper.addEmployee(employee);
    }

	public List<Employee> findApplicants() {
		return employeeMapper.findApplicants();
	}

	public void updateStatus(Integer employeeid, Integer status) {
        employeeMapper.updateStatus(employeeid, status);
	}

    public List<Employee> findByEmp(Employee employee) {
		return employeeMapper.findByEmp(employee);
	}

	public void removeEmp(Integer id) {
        employeeMapper.updateStatus(id, 2);
	}
}