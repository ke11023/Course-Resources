package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StageFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;      
        HttpServletResponse response = (HttpServletResponse) arg1;      
        HttpSession session = request.getSession();      
        String url=request.getServletPath();  
        String contextPath=request.getContextPath();  
        if(url.equals("")) url+="/";  
        if(url.startsWith("/stage")||url.startsWith("/studentpage")||url.startsWith("/resource")){//若访问后台资源 过滤到login  
             String user=(String)session.getAttribute("student_id");  
             if(user==null){//转入管理员登陆页面  
                  response.sendRedirect(contextPath); 
                  return;  
             }  
        }  
        arg2.doFilter(arg0, arg1);    
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
