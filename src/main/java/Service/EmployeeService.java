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

    /**
     * 获取员工数据，以及分页查询，以及条件查询。
     * @param page
     * @param employee
     * @return
     */
    Map<String, Object> getEmployees(Page page, Employee employee);

    Integer getCount();

    /**
     * 增加新员工
     * @param employee
     * @return
     */
    Boolean addNewEmployee(Employee employee);

    /**
     * 修改员工数据
     * @param employee
     * @return
     */
    Boolean editUser(Employee employee);

    /**
     * 删除员工数据
     * @param e_id
     * @return
     */
    Boolean deleteOne(Integer e_id);

    Employee findById(Integer e_id);
}
