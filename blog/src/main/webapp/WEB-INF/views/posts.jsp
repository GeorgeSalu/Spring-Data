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
		<div>
			<form action="<c:url value="/search" />" method="get">
				<input name="texto" type="search" placeholder="busca por palavra chave">
				<input type="submit" value="Localizar">
			</form>
		</div>
		<c:forEach var="p" items="${page.content }">
			<div>
				<div>
					<h2> <a href="<c:url value="/${p.permalink }" />" title="${p.titulo }" > ${p.titulo } </a> </h2>
					<p>
						Autor : <a href="<c:url value="/autor/${p.autor.id}/page/1" />"> ${p.autor.nome } </a> 
						| 
						Data : ${p.dataPostagem }
						| # ${fn:length(p.comentarios) }
					</p>
				</div>
				<div>
					<p class="post-texto">
						<!-- delimitando a quantidade de informação que vai pra tela -->
						<c:forTokens var="resumo" items="${p.texto }" delims=" " begin="0" end="10">
							${resumo }
						</c:forTokens><a href="<c:url value="/${p.permalink }" />">[Leia Mais]</a>
					</p>
				</div>
				<div>
					<p>
						<c:forEach var="c" items="${p.categorias }">
							<a href="<c:url value="/categoria/${c.permalink }/page/1" />" title="${c.descricao }"> 
							| ${c.descricao} </a>
						</c:forEach>
					</p>
				</div>
			</div>
		</c:forEach>
		<c:import url="paginacao.jsp"></c:import>
	</fieldset>
</body>
</html>