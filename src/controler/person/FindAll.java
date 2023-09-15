package controler.person;

import common.WrapperClass;
import model.domain.Person;
import model.service.PersonService;
import model.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/person/findAll.do")
public class FindAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService personService = new PersonServiceImpl();
            req.setAttribute("personList", personService.findAll());
            req.getRequestDispatcher("/person/index.jsp").forward(req,resp);
        } catch (Exception e) {
            resp.sendError(WrapperClass.get(e));
        }
    }
}
