<%-- 
    Document   : MarcaTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Marca"%>
<%@page import="org.gerdoc.helper.MarcaHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Marca>marcaList = null;
    marcaList = new MarcaHelper( ).getList( );
    if( marcaList == null || marcaList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista marca sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>Id</th>
                        <th>Marca</th>
                    </tr>
                </thead>
<%
    for( Marca marca : marcaList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=marca.getIdMarca()%>
                        </td>
                        <td>
                            <%=marca.getMarca()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>