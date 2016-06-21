<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagem</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	<c:import url="../menu.jsp"/>
	<c:url var="save" value="/postagem/ajax/save"/>
	<form id="save-ajax" action="${save}" method="post" >
		<fieldset>
			<legend> Cadastro de Postagem</legend>
			<div class="campo">
				<label for="titulo">Titulo do Post</label><br>
				<input name="titulo" type="text" required="true" size="60"/>
			</div>
			<br>
			<div class="campo">
				<label for="texto">Texto do Post</label><br>
				<textarea name="texto" rows="15" cols="80"/>
			</div>
			<div class="campo">
				<label for="categorias">Selecione a(s) Categorias(s)</label>
				<select name="categorias" multiple>
					<c:forEach var="c" items="${categorias }">
						<option value="${c.id }" >${c.descricao }</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input type="submit" value="Salvar">
				<input type="reset" value="Limpar">
			</div>
		</fieldset>	
	</form>
	<div id="info"></div>
</body>
</html>