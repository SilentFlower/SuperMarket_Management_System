package Controller;

import Domain.Employee;
import Domain.Page;
import Domain.Supplier;
import Domain.User;
import Service.EmployeeService;
import Util.JsonUtil;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author SiletFlower
 * @date 2020/11/15 09:06:10
 * @description
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getEmployee")
    @ResponseBody
    public ModelAndView getEmployee(ModelAndView mv, Page page,String employee){
        Employee key = null;
        if(employee != null && !"".equals(employee)){
            key = JsonUtil.toEmployee(employee);
        }
        Map<String, Object> map = employeeService.getEmployees(page,key);
        Page newPage = (Page) map.get("page");
        Object employees = map.get("employees");
        String employeesString = JsonUtil.toJsonUtil(employees);
        String keyString = JsonUtil.toJsonUtil(key);
        mv.addObject("employees",employeesString);
        mv.addObject("page",newPage);
        mv.addObject("employeeKeyword",keyString);
        mv.setViewName("employeeList");
        return mv;
    }

    @RequestMapping("/addNew")
    @ResponseBody
    public boolean addNew(Employee employee,User user){
        employee.setUser(user);
        Boolean a = employeeService.addNewEmployee(employee);
        return a;
    }


    @RequestMapping("/edit")
    @ResponseBody
    public boolean edit(Employee employee, User user){
        employee.setUser(user);
        Boolean a = employeeService.editUser(employee);
        return a;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Employee getOne(ModelAndView mv,String email){
        Employee employee = employeeService.findByEmail(email);
        return employee;
    }

    @RequestMapping("/deleteOne")
    @ResponseBody
    public boolean deleteOne(String email){
        Boolean d = employeeService.deleteOne(email);
        return d;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public boolean deleteAll(String[] emails){
        for (String email : emails) {
            Boolean a = employeeService.deleteOne(email);
            if(a){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

}
