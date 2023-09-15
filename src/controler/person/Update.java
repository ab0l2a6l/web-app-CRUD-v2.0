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

@WebServlet("/person/update.do")
public class Update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Person person = new Person();
            person.setId(Long.parseLong(req.getParameter("id")));
            person.setName(req.getParameter("name"));
            person.setFamily(req.getParameter("family"));
            PersonService personService = new PersonServiceImpl();
            personService.update(person);
            resp.sendRedirect("/person/findAll.do");
        }catch (Exception e){
            resp.sendError(WrapperClass.get(e));
        }
    }
}
