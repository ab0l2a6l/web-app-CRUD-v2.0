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

@WebServlet("/student/save.do")

public class Save extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setId(Long.parseLong(req.getParameter("id")));
            student.setName(req.getParameter("name"));
            student.setFamily(req.getParameter("family"));

            StudentService service = new StudentServiceImpl();
            service.save(student);
            resp.sendRedirect("/student/findAll.do");
        }catch (Exception e){
            resp.sendError(WrapperClass.get(e));
        }
    }
}
