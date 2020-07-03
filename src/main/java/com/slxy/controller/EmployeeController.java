package com.slxy.controller;

import com.slxy.dao.EmployeeDao;
import com.slxy.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 员工处理相关
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping(value = "/emps")
    public String getEmployeeList(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();

        model.addAttribute("emps", employeeList);

        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "/list";
    }

    @GetMapping(value = "/emp")
    public String getAddEmployee() {
        return "/emp";
    }

}
