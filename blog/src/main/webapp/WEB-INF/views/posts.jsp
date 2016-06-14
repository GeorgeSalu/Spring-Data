<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Postagem</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	
	<fieldset class="header">
		<h1>Blog do curso de spring</h1>
	</fieldset>
	<c:import url="menu.jsp"/>
	<fieldset>
		<c:forEach var="p" items="${postagens }">
			<div>
				<div>
					<h2>${p.titulo }</h2>
					<p>
						Autor : ${p.autor.nome } | Data : ${p.dataPostagem }
					</p>
				</div>
				<div>
					<h2>${p.texto }</h2>
				</div>
				<div>
					<p>
						<c:forEach var="c" items="${p.categorias }">
							| ${c.descricao}
						</c:forEach>
					</p>
				</div>
			</div>
		</c:forEach>
	</fieldset>
</body>
</html>