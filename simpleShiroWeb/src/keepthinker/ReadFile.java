package keepthinker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class ReadFile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext cntxt = this.getServletContext();
		String fName = "/WEB-INF/input.txt";
		InputStream ins = cntxt.getResourceAsStream(fName);

		if(ins != null){
			InputStreamReader isr = new InputStreamReader(ins);
			BufferedReader reader = new BufferedReader(isr);
			
			String word ="";
			while((word= reader.readLine())!= null)
			{
				System.out.println(word);
			}

		}else{
			System.out.println("error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
