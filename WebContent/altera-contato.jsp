<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Formulário de alteração</h3>
	<form action="mvc" method="get">
		Id: <input type="text" value="${param.id}" name="id" readonly="readonly"/><br/>
		Nome: <input type="text" value="${param.nome}" name="nome"/><br/>
		Email: <input type="text" value="${param.email}" name="email"/><br/>
		Endereço: <input type="text" value="${param.endereco}" name="endereco"/><br/>
		<%@taglib tagdir="/WEB-INF/tags" prefix="junior" %>
		Nascimento: <junior:campoData id="dataNascimento" />
		
		
		<input type="hidden" name="logica" value="AlteraContatoLogic"/>
		<input type="submit" value=" Salvar "/>
	</form>
</body>
</html>