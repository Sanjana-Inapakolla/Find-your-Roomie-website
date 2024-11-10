<%@ page import="java.util.*, java.io.*" %>
<%
    // Assuming messages are stored in a file or database, read them here
    File file = new File(application.getRealPath("/") + "messages.txt");
    if (file.exists()) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line + "<br>");
        }
        reader.close();
    }
%>
