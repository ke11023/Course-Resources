package filter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class StageInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 // ȡ��������ص�ActionContextʵ��  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get("student_id");  
  
        // ���û�е�½�����ߵ�½���е��û�������yuewei�����������µ�½  
  
        if (user != null) {   
            return invocation.invoke();  
        }  
  
        ctx.put("tip", "�㻹û�е�¼");  
        return "input";  
	}

}