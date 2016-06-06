<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE htm>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Usuario</title>
		<style type="text/css">
			.campo {
				margin-bottom: 1em;
			}
			.campo input:FOCUS, .campo select:FOCUS {
				background: #f8f8f8;
			}
			.table {
				width: 640px;
				text-align: center;
			}
			fieldset {
				width: 640px;
				margin: 0 auto;
			}
			fieldset.group .campo {
				float: left;
				margin-left: 2em;
			}
			.master {
				width: 960px;
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		<c:url var="save" value="/usuario/save"></c:url>
		<form:form modelAttribute="usuario" action="${save}" method="post" enctype="multipart/form-data">
			
			<fieldset>
				<legend>Cadastro de Usuario</legend>
				<div>
					<form:label path="nome">Nome do Usuario</form:label><br>
					<form:input path="nome" type="text" required="true"/>
				</div>
				<br>
				<div>
					<form:label path="email">E-mail</form:label><br>
					<form:input path="email" type="email" required="true" />
				</div>
				<br>
				<div>
					<form:label path="senha">Senha</form:label><br>
					<form:password path="senha" required="true" />
				</div>
				<br>
				<div>
					<label for="file">Avatar</label><br>
					<input type="file" name="file" required="true">
				</div>
				<br>
				<div>
					<form:label path="perfil">Perfil</form:label><br>
					<form:select path="perfil" required="true">
						<form:option value="ADMIN" label="ADMIN"></form:option>
						<form:option value="AUTOR" label="AUTOR"></form:option>
						<form:option value="LEITOR" label="LEITOR"></form:option>
					</form:select>
				</div>
				<br>
				<div>
					<input type="submit" value="Salvar">
					<input type="reset" value="Limpar">
				</div>
			</fieldset>
			
		</form:form>	
	</body>
</html>