package tao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tao.model.Employee;

public interface EmployeeMapper {
	public Employee queryEmployee(Employee employee);
	public Employee queryEmployeeByUsername(String username);
	public Integer addEmployee(Employee employee);
	public List<Employee> findApplicants();
	public void updateStatus(@Param("employeeid")Integer employeeid,@Param("status")Integer status);
	public List<Employee> findByEmp(Employee employee);
	public List<Employee> findEmpsByDepId(Integer DepId);
}