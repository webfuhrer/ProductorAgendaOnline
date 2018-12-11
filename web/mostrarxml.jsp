<%@page import="paqueteproductor.PintarXML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteproductor.Contacto"%>
<%
    ArrayList<Contacto> lista_contactos=(ArrayList<Contacto>)request.getAttribute("lista_contactos");
    String xml=PintarXML.pintar(lista_contactos);
    %>
    <%=xml%>
