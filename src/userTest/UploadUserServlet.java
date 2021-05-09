package userTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uploadUserServlet")
public class UploadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userID");
		String name = request.getParameter("name");
		String userPass = request.getParameter("userPass");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		vo.setUserID(userId);
		vo.setName(name);
		vo.setUserPass(userPass);
		vo.setPhone(phone);
		vo.setGender(gender);
		
		int userInsertResultCount = dao.getInsert(vo);
		
		System.out.println("insert query result : "+ userInsertResultCount);
		
		response.sendRedirect("/UserProj/userInfo.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
