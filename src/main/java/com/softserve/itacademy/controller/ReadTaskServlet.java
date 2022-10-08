package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = {"/read-task"})
public class ReadTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Task task = taskRepository.read(id);
        request.setAttribute("task", task);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/read-task.jsp");

//        request.setAttribute();

//        task.setTitle(request.getParameter("title"));
//        task.setPriority(priority);
    }


}
