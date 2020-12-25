package Service.Impl;

import Dao.EmployeeDao;
import Dao.EmployeeSaleDao;
import Dao.GoodsDao;
import Dao.UserDao;
import Domain.*;
import Service.EmployeeService;
import Util.MD5Util;
import Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private EmployeeSaleDao employeeSaleDao;

    @Autowired
    private GoodsDao goodsDao;


    /**
     * 获取员工数据，以及分页查询，以及条件查询。
     * @param page
     * @param employee
     * @return
     */
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


    /**
     *增加新员工
     * @param employee
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public Boolean addNewEmployee(Employee employee) {
        //首先查找email是否重复
        Employee find1 = employeeDao.findByEmail(employee.getEmployee_email());
        //查找user_name是否重复
        Integer find2 = userDao.findIdByName(employee.getUser().getUser_name());
        if(find1 == null && find2 == null){
            //加密操作
            String password = MD5Util.MD5(employee.getUser().getPassword());
            User user = employee.getUser();
            user.setPassword(password);
            //插入user表
            Integer integer1 = userDao.addNewUser(user);
            //为了获取u_id
            Integer u_id = userDao.findIdByName(employee.getUser().getUser_name());
            employee.setU_id(u_id);
            //添加员工
            Integer integer = employeeDao.addEmployee(employee);
            if(integer > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 修改员工的数据
     * @param employee
     * @return
     */
    @Override
    public Boolean editUser(Employee employee) {
        //根据唯一键邮箱返回员工数据
        Employee before = employeeDao.findById(employee.getE_id());
        //检测邮箱变化
        if(!employee.getEmployee_email().equals(before.getEmployee_email())){
            //判断数据库内是否有同一邮箱返回false
            if (employeeDao.findByEmail(employee.getEmployee_email()) != null) {
                return false;
            }
        }
        Integer integer = employeeDao.updateEmployee(employee);
        //比较用户名的密码是否改变
        Integer integer2 = 0;
        if(!employee.getUser().getPassword().equals(before.getUser().getPassword())){
            User user = employee.getUser();
            //加密
            String password = MD5Util.MD5(user.getPassword());
            user.setPassword(password);
            integer2 = userDao.updateUser(user);
        }
        if(!employee.getUser().getAdmin().equals(before.getUser().getAdmin())){

            userDao.updateAdmin(employee.getUser());
        }
        if (integer > 0 || integer2 > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Employee findById(Integer e_id) {
        return employeeDao.findById(e_id);
    }


    /**
     * 联表删除逻辑实现
     * @param e_id
     * @return
     */
    @Override
    public Boolean deleteOne(Integer e_id) {
        Employee employee = employeeDao.findById(e_id);
        //首先删除employee的数据
        Integer i1 = employeeDao.deleteById(employee.getE_id());
        //删除user表用户
        Integer i2 = userDao.deleteById(employee.getU_id());
        //首先获取此用户下关联的销售记录
        List<SaleGoods> sale_goods = employeeSaleDao.get_employeeSale_e_id(employee.getE_id());
        //删除sale_goods表数据
        employeeSaleDao.delete_employeeSale_e_id(employee.getE_id());
        //更新goods表的库存
        for (SaleGoods sale_good : sale_goods) {
            Integer i3 = goodsDao.update_amount_plus(sale_good.getG_id(),sale_good.getSale_amount());
        }
        if(i1 > 0){
            return true;
        }
        return false;
    }

}
