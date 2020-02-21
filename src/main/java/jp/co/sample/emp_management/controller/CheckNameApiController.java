package jp.co.sample.emp_management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.emp_management.domain.Employee;
import jp.co.sample.emp_management.service.EmployeeService;

@RestController
@RequestMapping(value = "/check_name_api")
public class CheckNameApiController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/namecheck", method = RequestMethod.POST)
	public Map<String, String[]> namecheck(String name){
		Map<String, String[]> map = new HashMap<>();
		List<Employee> employeeList = employeeService.findByName(name);
		String[] nameArray = new String[employeeList.size()];
		int counter = 0;
		for(Employee employee: employeeList) {
			nameArray[counter] = employee.getName();
			counter++;
 		}
		System.out.println(nameArray);
		map.put("nameArray", nameArray);
		return map;
	}

}
