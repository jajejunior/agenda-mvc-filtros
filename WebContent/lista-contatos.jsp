<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de contatos</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<td><b>ID</b></td>
			<td><b>NOME</b></td>
			<td><b>EMAIL</b></td>
			<td><b>ENDEREÇO</b></td>
			<td><b>DATA DE NASCIMENTO</b></td>
		</tr>
	</thead>
	<c:forEach var="contato" items="${contatos}"> 
		<tr>
			<td>${contato.id}</td>
			<td>${contato.nome}</td>
			<td>${contato.email}</td>
			<td>${contato.endereco}</td>
	
			<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>&nbsp;&nbsp;</td>
					
					
			<td><a href="mvc?logica=LinkAlteraContatoLogic&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&endereco=${contato.endereco}&dataNascimento=${contato.dataNascimento}">alterar</a></td>
					<td>&nbsp;</td>
			<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">remover</a></td>
			
		</tr>
	
	</c:forEach>

</table>

</body>
</html>

