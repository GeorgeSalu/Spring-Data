<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset style="font-family: monospace; font-size: 10pt;">
	<legend>Menu</legend>
	<nav>
		<a href="<c:url value="/" />">Home</a>
	</nav>
	<nav>
		<a href="<c:url value="/usuario/add" />">Add Usuario</a>
		<a href="<c:url value="/usuario/list" />">List Usuario</a>
	</nav>
	<nav>
		<a href="<c:url value="/autor/add" />">Add Autor</a>
		<a href="<c:url value="/autor/list" />">List Autor</a>
	</nav>
	<nav>
		<a href="<c:url value="/postagem/add" />">Add Postagem</a>
		<a href="<c:url value="/postagem/list" />">List Postagens</a>
		<a href="<c:url value="/postagem/ajax/add" />">add Postagens Ajax</a>
	</nav>
	<nav>
		<a href="<c:url value="/categoria/add" />">Add Categoria</a>
	</nav>
	<nav>
		<a href="<c:url value="/auth/form" />">Entrar</a>
		<a href="<c:url value="#" />">Cadastrar-se</a>
		<form action="<c:url value="/logout" />" method="post">
			<security:csrfInput/>
			<button type="submit">Sair</button>
		</form>
	</nav>
</fieldset>