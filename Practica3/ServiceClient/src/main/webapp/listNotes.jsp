<html>
<head>
<title>Notas</title>
</head>
<%
	String respuesta=(String) request.getAttribute("listNotes");
%>
<div><span style="float:right"><b>LISTADO DE NOTAS</b><br><%=respuesta %></span>
<fieldset>
<h1 >Creacion rapida de notas</h1>
	<form method="post" action="hi" >
		<p><label >Task:</label></p>
                        <input name="task" type="text" id="task">
        <p><label>Context:</label></p>
                        <input name="context" type="text" id="context">
 		<p><label>Project:</label></p>
                        <input name="proyect" type="text" id="proyect">              
        <p><label>Priority:</label></p>
        	<input name="priority" type="number" id="priority">
        <p><input type="submit" id="submit" onclick="pregunta()" name="submit" value="Crear" class="boton"></p>
	</form>
</fieldset>
<fieldset>
<h2>Eliminacion de notas</h2>
	<form method="post" action="delete">
	<select name="menu">
	  <option selected="selected" value="Task">Task</option>
	  <option value="Context">Context</option>
	  <option value="Project">Project</option>
	</select>
	<input name="campo" type="text" id="campo">
    <p><input type="submit" id="submit" name="submit" value="Aceptar" class="boton"></p>
    <p><input type="submit" id="submit" name="submit" value="Borrar todo" class="boton"></p>
    </form>
</fieldset>
<fieldset>
<h3>Filtrado de notas</h3>
	<form method="post" action="listar">
	<select name="menu">
	  <option selected="selected" value="Task">Task</option>
	  <option value="Context">Context</option>
	  <option value="Project">Project</option>
	</select>
	<input name="campo" type="text" id="campo">
    <p><input type="submit" id="submit" name="submit2" value="Aceptar Filter" class="boton"></p>
    <p><input type="submit" id="submit" name="submit2" value="Lista completa" class="boton"></p>
    </form>
</fieldset>
</div>
</html>