package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RecipeList", value = "/app/recipe/list")
public class RecipeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> allRecipes = recipeDao.findAll((Admin) session.getAttribute("admin"));
        request.setAttribute("recipes", allRecipes);
        getServletContext().getRequestDispatcher("/WEB-INF/recipe/recipe_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
