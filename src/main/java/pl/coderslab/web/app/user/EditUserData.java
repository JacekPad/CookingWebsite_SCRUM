package pl.coderslab.web.app.user;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUserData", value = "/app/user/edit")
public class EditUserData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        request.getServletContext().getRequestDispatcher("/WEB-INF/user/user_edit_data.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminDao adminDao = new AdminDao();
        Integer id = Integer.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Admin adminToEdit = adminDao.read(id);
        adminToEdit.setFirstName(firstName);
        adminToEdit.setLastName(lastName);
        adminToEdit.setEmail(email);

        adminDao.updateUserData(adminToEdit);
        session.setAttribute("admin",adminToEdit);

        response.sendRedirect("/app/dashboard");


    }
}
