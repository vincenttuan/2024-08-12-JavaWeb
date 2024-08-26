package employee.controller;

import java.io.IOException;
import java.util.List;

import employee.dao.EmployeeDao;
import employee.entity.EmployeeName;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employee/list")
public class EmployeeServlet extends HttpServlet {
	
	private EmployeeDao dao = new EmployeeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 查詢所有員工姓名
		List<EmployeeName> employeeNames = dao.findAllNames(); 
		
		// 將 employeeNames 丟給 /WEB-INF/jsp/employee_list.jsp 來渲染
		// RequestDispatcher 是分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/employee_list.jsp");
		req.setAttribute("employeeNames", employeeNames); // 帶給 jsp 的資料
		rd.forward(req, resp); // 帶著資料傳遞到指定位置
	}
	
}
