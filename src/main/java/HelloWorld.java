import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.webapp.WebAppContext;

public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Hello from Java!\n");
    }
    public static void main(String[] args) throws Exception{
		System.setProperty("org.apache.jasper.compiler.disablejsr199","true");
        
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        
		/*
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorld()),"/*");
		*/
		
		WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/SecureWebProject");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
		
        server.start();
        server.join();
    }
}