<%-- 
    Document   : UnoForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<%@page import="org.gerdoc.helper.MarcaProvedorHelper"%>
<%@page import="org.gerdoc.dao.Producto"%>
<%@page import="org.gerdoc.helper.ProvedorHelper"%>
<%@page import="org.gerdoc.dao.Provedor"%>
<%@page import="org.gerdoc.dao.Marca"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.helper.MarcaHelper"%>
<%
    Producto producto = new MarcaProvedorHelper().getProductoById(request);
    if( producto == null)
    {
        producto = new Producto( );
        producto.setNombre("");
        producto.setDescripcion("");
        producto.setUrl("");
        producto.setPrecioPub(null);
        producto.setCosto(null);
    }
    
%>
    <form action="MarcaProvedorList.jsp">
        <div class="row mt-4 grey">
            <div class="col">
                <div class="mb-3 mt-3">
                    <label for="nombre">Nombre del producto:</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Escribe un nombre" name="nombre">
                </div>
                <div class="mb-3 mt-3">
                    <label for="descripcion">Descripci�n:</label>
                    <input type="text" class="form-control" id="descripcion" placeholder="Escribe una descripci�n" name="descripcion">  
                </div>
                <div class="mb-3 mt-3">
                    <label for="url">Url</label>
                    <input type="text" class="form-control" id="url" placeholder="Escribe una URL" name="url">  
                </div>
                <div class="mb-3 mt-3">
                    <label for="preciopub">Precio Publico:</label>
                    <input type="number" class="form-control" id="preciopub" placeholder="Escribe el precio al publico" name="preciopub">  
                </div>
                <div class="mb-3 mt-3">
                    <label for="costo">Costo:</label>
                    <input type="number" class="form-control" id="costo" placeholder="Escribe el costo del producto" name="costo">  
                </div>

            </div>
            <div class="col">
                <div class="mb-3 mt-3">
                    <label for="marca">Marca:</label>
                    <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example" id="marca" placeholder="Escribe una marca" name="marca">
                        <option selected>Selecciona una marca</option>
                        <%
                            List<Marca>marcaList = new MarcaHelper( ).getList( );
                            if( marcaList != null && marcaList.size() > 0 )
                            {
                               for( Marca marca : marcaList )
                               {
                        %>
                                    <option value="<%=marca.getIdMarca()%>"><%=marca.getMarca()%></option>
                        <%
                               }
                            }
                        %>
                      </select>
                </div>
            </div>
            <div class="col">
                <div class="mb-3 mt-3">
                    <label for="provedor">Provedor:</label>
                    <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example" id="provedor" placeholder="Escribe un provedor" name="provedor">
                        <option selected>Selecciona un provedor</option>
                        <%
                            List<Provedor>provedorList = new ProvedorHelper( ).getList( );
                            if( provedorList != null && provedorList.size() > 0 )
                            {
                               for( Provedor provedor : provedorList )
                               {
                        %>
                                    <option value="<%=provedor.getIdProvedor()%>"><%=provedor.getProvedor()%></option>
                        <%
                               }
                            }
                        %>
                      </select>
                </div>
            </div>
        </div>
        <div class="row mt-4 grey">
                    <%
                    if(producto.getIdProducto()!= null && producto.getIdProducto() > 0 )
                    {
                %>
                        <input type="hidden" id="action" name="action" value="actualizar" />
                        <input type="hidden" id="id" name="id" value="<%=producto.getIdProducto()%>" />
                <%
                    }
                    else
                    {
                %>
                        <input type="hidden" id="action" name="action" value="send" />
                <%
                    }
                %>
            <input type="hidden" id="action" name="action" value="send" />
            <div class=""input-group mb-3">
                <button type="submit" class="btn btn-primary">Enviar</button>
                <button type="reset" class="btn btn-primary">Borrar</button>
            </div>
        </div>
    </form>
                      
<br/>
<div class="row mt-6">
    <a href="?">
        <button type="button" class="btn btn-outline-primary" >Regresar</button>
    </a>
</div>
