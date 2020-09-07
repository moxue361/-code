package tao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tao.mapper.DepartmentMapper;
import tao.model.Department;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> findAll() {
        return departmentMapper.findAll();
    }


	public void addDep(String departmentname) {
        if(departmentMapper.findOneByDepName(departmentname)==null){
            departmentMapper.addDep(departmentname);
        }
	}


	public void delDep(Integer depId) {
        departmentMapper.delDep(depId);
	}


	public Integer updateDep(Integer id, String name) {
		if(departmentMapper.findOneByDepName(name)==null){
            return departmentMapper.updateDep(id,name);
        }
        else return 0;
	}


}