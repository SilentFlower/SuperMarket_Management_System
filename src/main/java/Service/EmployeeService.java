package Service;

import Domain.Employee;
import Domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/15 09:07:49
 * @description
 */
public interface EmployeeService {

    Map<String, Object> getEmployees(Page page, Employee employee);

    public Integer getCount();

    public Boolean addNewEmployee(Employee employee);

    public Boolean editUser(Employee employee);

    public Employee findByEmail(String email);

    public Boolean deleteOne(String email);


}
