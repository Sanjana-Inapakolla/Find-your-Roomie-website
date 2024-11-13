/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.30
 * Generated at: 2024-11-13 11:14:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class Rating_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Star Rating</title>\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("<style>\n");
      out.write("    body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: center;\n");
      out.write("        align-items: center;\n");
      out.write("        height: 100vh;\n");
      out.write("        margin: 0;\n");
      out.write("        background-color:#008080; /* Light gray */\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .container {\n");
      out.write("        width: 800px;\n");
      out.write("        background-color: #FFFFFF; /* White background for container */\n");
      out.write("        padding: 20px;\n");
      out.write("        border-radius: 10px;\n");
      out.write("        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .reviews {\n");
      out.write("        background-color: #FFFBCC; /* Soft yellow for review section */\n");
      out.write("        padding: 15px;\n");
      out.write("        border-radius: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h1 {\n");
      out.write("        color: #FF6F00; /* Vibrant orange */\n");
      out.write("        margin-bottom: 15px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .star {\n");
      out.write("        font-size: 60px;\n");
      out.write("        cursor: pointer;\n");
      out.write("        transition: color 0.3s ease;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Star color based on ratings */\n");
      out.write("    .star.one, .star.two {\n");
      out.write("        color: #FF6F00; /* Orange for low ratings */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .star.three {\n");
      out.write("        color: #FFDD00; /* Yellow for medium ratings */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .star.four, .star.five {\n");
      out.write("        color: #008080; /* Teal for high ratings */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .hostel-info {\n");
      out.write("        display: flex;\n");
      out.write("        gap: 10px;\n");
      out.write("        margin: 15px 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .hostel-info input[type=\"text\"] {\n");
      out.write("        flex: 1;\n");
      out.write("        padding: 10px;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        border-radius: 5px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #review_text {\n");
      out.write("        width: 80%;\n");
      out.write("        height: 80px;\n");
      out.write("        padding: 10px;\n");
      out.write("        border: 1px solid #ccc;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        margin-top: 15px;\n");
      out.write("        resize: none;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #submitbutton {\n");
      out.write("        margin-top: 20px;\n");
      out.write("        padding: 10px 20px;\n");
      out.write("        border: none;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        background-color: #008080; /* Teal for the button */\n");
      out.write("        color: #FFFFFF; /* White text */\n");
      out.write("        cursor: pointer;\n");
      out.write("        font-size: 16px;\n");
      out.write("        transition: background-color 0.3s ease;\n");
      out.write("        display: block;\n");
      out.write("        margin-left: auto;\n");
      out.write("        margin-right: auto;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #submitbutton:hover {\n");
      out.write("        background-color: #FF6F00; /* Orange on hover */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-close {\n");
      out.write("        position: absolute;\n");
      out.write("        top: 20px;\n");
      out.write("        left: 20px;\n");
      out.write("        width: 30px;\n");
      out.write("        height: 30px;\n");
      out.write("        font-size: 1.2rem;\n");
      out.write("        background-color: #FFDD00; /* Yellow close button */\n");
      out.write("        border: none;\n");
      out.write("        cursor: pointer;\n");
      out.write("        border-radius: 50%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .btn-close:hover {\n");
      out.write("        background-color: #FF6F00; /* Orange on hover */\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<button type=\"button\" class=\"btn-close\" aria-label=\"Close\" onclick=\"window.location.href='home.html';\"></button>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Rate your hostel</h1>\n");
      out.write("        \n");
      out.write("        <div class=\"reviews\">\n");
      out.write("            <!-- Star Rating -->\n");
      out.write("            <span onclick=\"rating(1)\" class=\"star\">★</span>\n");
      out.write("            <span onclick=\"rating(2)\" class=\"star\">★</span>\n");
      out.write("            <span onclick=\"rating(3)\" class=\"star\">★</span>\n");
      out.write("            <span onclick=\"rating(4)\" class=\"star\">★</span>\n");
      out.write("            <span onclick=\"rating(5)\" class=\"star\">★</span>\n");
      out.write("            <h3 id=\"output\">Rating is : 0/5</h3>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Hostel Information -->\n");
      out.write("        <form action=\"Review\" method=\"post\">\n");
      out.write("            <div class=\"hostel-info\">\n");
      out.write("                <input type=\"text\" name=\"hostel-city\" placeholder=\"Hostel City\" required>\n");
      out.write("                <input type=\"text\" name=\"hostel-area\" placeholder=\"Hostel Area\" required>\n");
      out.write("                <input type=\"text\" name=\"hostel-name\" placeholder=\"Hostel Name\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Review Text Box -->\n");
      out.write("            <textarea id=\"review_text\" name=\"reviewText\" placeholder=\"Write your review here...\" required></textarea>\n");
      out.write("            \n");
      out.write("            <!-- Submit Button -->\n");
      out.write("            <button type=\"submit\" id=\"submitbutton\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        const stars = document.querySelectorAll(\".star\");\n");
      out.write("        const output = document.getElementById(\"output\");\n");
      out.write("\n");
      out.write("        function rating(n) {\n");
      out.write("            removeHighlight();\n");
      out.write("            for (let i = 0; i < n; i++) {\n");
      out.write("                let cls = \"\";\n");
      out.write("                if (n == 1 || n == 2) cls = \"one\";\n");
      out.write("                else if (n == 3) cls = \"three\";\n");
      out.write("                else cls = \"five\";\n");
      out.write("\n");
      out.write("                stars[i].classList.add(cls);\n");
      out.write("            }\n");
      out.write("            output.innerText = \"Rating is: \" + n + \"/5\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function removeHighlight() {\n");
      out.write("            stars.forEach(star => star.className = \"star\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}