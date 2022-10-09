package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = {"/update-task"})
public class UpdateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;
    private Task task;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        task = taskRepository.read(id);
        if (task != null) {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request, response);
        } else {
            request.setAttribute("pageURL", "/update-task");
            response.sendError(404);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        Priority priority = Priority.valueOf(request.getParameter("priority").toUpperCase());
        if(!title.isBlank()) {
            task.setTitle(title);
        } else {
            request.setAttribute("pageURL", "/update-task");
            response.sendError(404);
        }
        task.setPriority(priority);
        if (taskRepository.update(task)) {
            response.sendRedirect("/tasks-list");
        } else {
            request.setAttribute("pageURL", "/update-task");
            response.sendError(404);
        }
    }
}
