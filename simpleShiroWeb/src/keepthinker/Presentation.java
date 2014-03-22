package keepthinker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
public class Presentation extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		PrintWriter writer=res.getWriter();
		Subject sub=SecurityUtils.getSubject();
		writer.write((String)sub.getPrincipal());
	}
	

}
