package keepthinker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1934571895132L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);*/
		UsernamePasswordToken token =
				new UsernamePasswordToken( (String)req.getParameter("account"),
						(String)req.getParameter("password"));
		//”Remember Me” built-in, just do this:
		token.setRememberMe(true);
		//With most of Shiro, you'll always want to make sure you're working with the currently executing user, referred to as the subject
		Subject currentUser = SecurityUtils.getSubject();

		//Authenticate the subject by passing
		//the user name and password token
		//into the login method
		currentUser.login(token);
		getServletContext().getRequestDispatcher("/index.jsp")
		.forward(req, resp);

	}


}
