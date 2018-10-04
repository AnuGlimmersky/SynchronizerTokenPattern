package myservices;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class Login extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //generate a session id 
        String sessionid = UUID.randomUUID().toString();
        Cookie cookie_1 = new Cookie("sessionid", sessionid);
        
        //set cookie lifetime to 1 hour
        cookie_1.setMaxAge(3600); 
        cookie_1.setSecure(false);
        
    	//store session id in the browser as a cookie 
        resp.addCookie(cookie_1);
        service(req, resp);
    }

    private static String generateCSRFToken(){
    	
        String CSRFToken = null;
        byte[] arr = new byte[16];       
           
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            secureRandom.nextBytes(arr);
            CSRFToken = new String(Base64.getEncoder().encode(arr));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();   //if JAVA 8 is not available
        }

        return CSRFToken;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            //Obtain auto generated cookie in the browser
            Cookie[] cookies = req.getCookies();
            cookies[0].setPath("/");
            
            
            //Login credentials validation
            if (username.equals("admin") && password.equals("admin")) {
            	//start session for the current user
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                Storage.getSimpleStorage().addItem(cookies[0].getValue(), generateCSRFToken());
                System.out.println("Inside Service Method in Login CSRF token="+Storage.getSimpleStorage().getItem(cookies[0].getValue()));
                Storage.getSimpleStorage().print();
                resp.sendRedirect("home.jsp");
            } else {
                out.println("Invalid username or password!! please enter correct credentials");
            }
        }finally {
            out.close();
        }

    }
}
