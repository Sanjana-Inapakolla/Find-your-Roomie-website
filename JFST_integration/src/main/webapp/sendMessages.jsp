<%@ page import="java.io.*" %>
<%
    String message = request.getParameter("message");
    if (message != null && !message.trim().isEmpty()) {
        FileWriter writer = new FileWriter(application.getRealPath("/") + "messages.txt", true);
        writer.write(message + "\n");
        writer.close();
    }
    response.sendRedirect("chat.jsp");
%>
