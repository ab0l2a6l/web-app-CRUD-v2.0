package controler.student;

import common.WrapperClass;
import model.service.StudentService;
import model.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/findAll.do")

public class FindAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            StudentService service = new StudentServiceImpl();
            req.setAttribute("studentList", service.findAll());
            req.getRequestDispatcher("/student/index.jsp").forward(req,resp);
        }catch (Exception e){
            resp.sendError(WrapperClass.get(e));
        }
    }
}
