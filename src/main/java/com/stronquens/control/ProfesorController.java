/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stronquens.control;

import com.stronquens.beans.ProfesorBean;
import com.stronquens.service.ProfesorService;
import com.stronquens.util.HibernateUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Armando
 */
@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @RequestMapping("profesorlist.json")
    public @ResponseBody
    List<ProfesorBean> getProfesorList() {
        HibernateUtil.createSessionFactory();
        return profesorService.findAll();
    }

    @RequestMapping(value = "/getProfesor/{id}")
    public @ResponseBody
    ProfesorBean getProfesor(@PathVariable("id") int id) {
        HibernateUtil.createSessionFactory();
        return profesorService.get(id);
    }

    @RequestMapping(value = "/addProfesor", method = RequestMethod.POST)
    public @ResponseBody
    void addProfesor(@RequestBody ProfesorBean oBean) {
        HibernateUtil.createSessionFactory();
        profesorService.saveOrUpdate(oBean);
    }

    @RequestMapping(value = "/updateProfesor", method = RequestMethod.PUT)
    public @ResponseBody
    void updateProfesor(@RequestBody ProfesorBean oBean) {
        HibernateUtil.createSessionFactory();
        profesorService.saveOrUpdate(oBean);
    }

    @RequestMapping(value = "/removeProfesor/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void removeProfesor(@PathVariable("id") int id) {
        HibernateUtil.createSessionFactory();
        ProfesorBean oProfesor = new ProfesorBean(id, null, null, null);
        profesorService.delete(oProfesor);
    }

}