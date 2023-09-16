package controler.student;

import common.WrapperClass;
import model.domain.Student;
import model.service.StudentService;
import model.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/remove.do")

public class Remove extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            StudentService service = new StudentServiceImpl();
            service.remove(id);
            resp.sendRedirect("/student/findAll.do");
        }catch (Exception e){
            resp.sendError(WrapperClass.get(e));
        }
    }
}
