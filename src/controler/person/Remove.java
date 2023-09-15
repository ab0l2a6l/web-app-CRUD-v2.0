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

@WebServlet("/person/remove.do")
public class Remove extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            PersonService personService = new PersonServiceImpl();
            personService.remove(id);
            resp.sendRedirect("/person/findAll.do");
        }catch (Exception e){
            resp.sendError(WrapperClass.get(e));
        }
    }
}
