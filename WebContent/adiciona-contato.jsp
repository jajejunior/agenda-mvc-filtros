<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Adiciona Contato</title>
</head>
<body>
<h3>Formulário de Cadastro</h3><br/>
	<form action="mvc" method="get">
		Nome: <input type="text" name="nome" value=""/><br/>
		Email: <input type="text" name="email" value=""/><br/>
		Endereço: <input type="text" name="endereco" value=""/><br/>
	
		Nascimento: <input type="text" pattern="\d{1,2}/\d{1,2}/\d{4}" class="datepicker" name="dataNascimento" placeholder="dd/mm/aaaa" />
		
		<input type="hidden" name="logica" value="AdicionaContatoLogic">
		<input type="submit"  value="Gravar"/>
	</form>
</body>
</html>