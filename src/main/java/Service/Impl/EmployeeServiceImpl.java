package Service.Impl;

import Dao.EmployeeDao;
import Dao.UserDao;
import Domain.Employee;
import Domain.Page;
import Domain.Supplier;
import Service.EmployeeService;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/15 09:08:14
 * @description
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private UserDao userDao;


    @Override
    public Map<String, Object> getEmployees(Page page, Employee employee) {
        Map map = new HashMap<String,Object>();
        List<Employee> employees = null;
        Integer start = (page.getCurrentPage()-1)*page.getPageSize();
        Integer end = start+page.getPageSize();
        Page newPage = null;
        if(employee == null){
            Integer count = employeeDao.getCount();
            newPage = PageUtil.dealWithPage(page, count);
            employees = employeeDao.getByPage(start, newPage.getPageSize());
        }else {
            employees = employeeDao.searchByKey(employee);
            newPage = PageUtil.dealWithPage(page,employees.size());
            if(end >= newPage.getCount()){
                end = newPage.getCount();
            }
            employees = employees.subList(start,end);
        }
        map.put("employees",employees);
        map.put("page",newPage);
        return map;
    }

    @Override
    public Integer getCount() {
        return employeeDao.getCount();
    }

    @Override
    public Boolean addNewEmployee(Employee employee) {
        Employee find = employeeDao.findByEmail(employee.getEmployee_email());
        if(find != null){

        }else{
            if(userDao.findIdByName(employee.getUser().getUser_name()) == null){
                userDao.addNewUser(employee.getUser());
                Integer i = userDao.findIdByName(employee.getUser().getUser_name());
                employee.setU_id(i);
                employeeDao.addEmployee(employee);
                return true;
            }
        }
        return false;


    }

    @Override
    public Boolean editUser(Employee employee) {
        Employee before = employeeDao.findByEmail(employee.getEmployee_email());
        employee.setU_id(before.getU_id());
        if(!employee.equals(before)){
            employeeDao.updateEmployee(employee);
            if(!employee.getUser().equals(before.getUser())){
                userDao.updateUser(employee.getUser());
            }
            return true;
        }else if(!employee.getUser().equals(before.getUser())){
            userDao.updateUser(employee.getUser());
            return true;
        }
        return false;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeDao.findByEmail(email);
    }

    @Override
    public Boolean deleteOne(String email) {
        Employee employee = employeeDao.findByEmail(email);
        Integer integer = employeeDao.deleteById(employee.getE_id());
        if(integer > 0){
            Integer integer1 = userDao.deleteById(employee.getU_id());
            if(integer1 > 0){
                return true;
            }
        }
        return false;
    }

}
