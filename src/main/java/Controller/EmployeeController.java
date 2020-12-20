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

    /**
     * 获取分页数据以及根据条件查询
     * @param mv
     * @param page
     * @param employee
     * @return
     */
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
        mv.addObject("employees",JsonUtil.toJsonUtil(employees));
        mv.addObject("page",newPage);
        mv.addObject("employeeKeyword",JsonUtil.toJsonUtil(key));
        mv.setViewName("employeeList");
        return mv;
    }

    /**
     * 新增员工数据，绑定账户
     * @param employee
     * @param user
     * @return
     */
    @RequestMapping("/addNew")
    @ResponseBody
    public boolean addNew(Employee employee,User user){
        employee.setUser(user);
        Boolean a = employeeService.addNewEmployee(employee);
        return a;
    }


    /**
     * 修改数据
     * @param employee
     * @param user
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public boolean edit(Employee employee, User user){
        employee.setUser(user);
        Boolean a = employeeService.editUser(employee);
        return a;
    }

    /**
     * 获取到需要修改的数据
     * @param e_id
     * @return
     */
    @RequestMapping("/getOne")
    @ResponseBody
    public Employee getOne(Integer e_id){
        Employee employee = employeeService.findById(e_id);
        return employee;
    }

    /**
     * 删除一个员工数据
     * @param e_id
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public boolean deleteOne(Integer e_id){
        Boolean d = employeeService.deleteOne(e_id);
        return d;
    }

    /**
     * 删除多行员工数据
     * @param e_ids
     * @return
     */
    @RequestMapping("/deleteAll")
    @ResponseBody
    public boolean deleteAll(Integer[] e_ids){
        for (Integer e_id : e_ids) {
            Boolean a = employeeService.deleteOne(e_id);
            if(a){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

}
