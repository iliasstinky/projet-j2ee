package com.example.controller.spring.mvc.test.web;


import com.example.controller.spring.mvc.test.Business.taskmanagerrepo;
import com.example.controller.spring.mvc.test.doa.Entities.ProjectTask;
import com.example.controller.spring.mvc.test.doa.repositories.ProjectTaskrepo;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller

public class ProjectTaskController {
    @Autowired
    taskmanagerrepo taskman;

    @Autowired
    ProjectTaskrepo projectTaskrepo;

    @GetMapping("/TaskFormEditing")
    public String TaskFormEdit(@RequestParam(name = "id") int id , Model model){

        ProjectTask projectTask = taskman.getProjecttaskbyId(id);
        if (projectTask != null) {
            model.addAttribute("projectTasko", projectTask);
            return "Forms/TaskFormEdit";
        } else {
            return "error";
        }

    }
    @PostMapping("/saveTaskEditedForm")
    public String saveEditedTask(@ModelAttribute("projectTasko") ProjectTask projectTask ){
        projectTaskrepo.save(projectTask);
        return "redirect:cc";

    }
    @GetMapping("/cc")
  public String ProjectTaskshow(Model model){

        List<ProjectTask> projectTask = taskman.projecttaskshow();
          model.addAttribute("projectTask", projectTask);

        return "tasks/indexx";
    }
    @GetMapping("/Taskform")
    public String addTask(Model model){

        model.addAttribute("projectTask", new ProjectTask());
                return "Forms/Taskform";

    }
    @PostMapping("/saveTaskForm")
    public String saveTask(@ModelAttribute("Task") ProjectTask Task ){
        projectTaskrepo.save(Task);
        return "redirect:cc";

    }

   @GetMapping("/DeleteTask")

    public String DeleteTask(@RequestParam(name= "id") int id , Model model ){


       if  ( taskman.deleteTaskbyid(id)) {

           return "redirect:cc" ;
       } else {
           return "error";
       }


    }

     @GetMapping("/taskModal")
    public String ShowModalInfo(@RequestParam(name = "taskid") int taskid , Model model) {
         ProjectTask projectTask1 = taskman.getProjecttaskbyId(taskid);
         model.addAttribute("projectTask1", projectTask1);
         return "Forms/ShowTask";
     }
}

