<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset style="font-family: monospace; font-size: 10pt;">
	<legend>Menu</legend>
	<nav>
		<a href="<c:url value="/" />">Home</a>
	</nav>
	<nav>
		<security:authorize access="hasAnyAuthority('ADIMIN','AUTOR','LEITOR')">
			<a href="<c:url value="/usuario/perfil/${logado.id }" />">Perfil do usuario</a>
		</security:authorize>
		<security:authorize access="hasAuthority('ADIMIN')">
			<a href="<c:url value="/usuario/list" />">List Usuario</a>
		</security:authorize>
	</nav>
	<nav>
		<security:authorize access="hasAuthority('AUTOR')">
			<a href="<c:url value="/autor/add" />">Dados do Autor</a>
		</security:authorize>
		<security:authorize access="hasAuthority('ADIMIN')">
			<a href="<c:url value="/autor/list" />">Lista de Autores</a>
		</security:authorize>
	</nav>
	<nav>
		<security:authorize access="hasAuthority('AUTOR')">
		|	<a href="<c:url value="/postagem/add" />">Nova Postagem</a>
		|	<a href="<c:url value="/postagem/list/${logado.id }" />">List Postagens</a>	
		|	<a href="<c:url value="/postagem/ajax/add" />">Nova Postagens Ajax</a>
		</security:authorize>
		<security:authorize access="hasAuthority('ADIMIN')">
		|	<a href="<c:url value="/postagem/list" />">List Postagens</a>
		</security:authorize>
	</nav>
	<nav>
		<security:authorize access="hasAnyAuthority('ADIMIN','AUTOR')">
		<a href="<c:url value="/categoria/add" />">Add Categoria</a>
		</security:authorize>
	</nav>
	<nav>
	
		<c:if test="${ logado == null }">
			<a href="<c:url value="/auth/form" />">Entrar</a>
			<a href="<c:url value="/usuario/add" />">Cadastrar-se</a>
		</c:if>
		
		<security:authorize access="hasAnyAuthority('ADIMIN','AUTOR','LEITOR')">
			<form action="<c:url value="/logout" />" method="post">
				<security:csrfInput/>
				<button type="submit">Sair</button>
			</form>
		</security:authorize>
	</nav>
</fieldset>