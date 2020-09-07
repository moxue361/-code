package tao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tao.model.Department;

public interface DepartmentMapper {
    public List<Department> findAll();

    public Department findOneByDepName(String depName);
	public void addDep(String departmentname);

	public void delDep(Integer depId);

	public Integer updateDep(@Param("departmentid")Integer id, @Param("departmentname")String name);
}