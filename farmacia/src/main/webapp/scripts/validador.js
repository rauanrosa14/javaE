/**
 * 
 */

function validar()
{
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let email = frmContato.email.value
	let produto = frmContato.produto.value
	let cpf = frmContato.cpf.value
	let dia = frmContato.dia.value
	
	if(nome === "")
	{
		alert("Preencha o campo 'NOME'")
		frmContato.nome.focus()
		return false
	}else if(fone === "")
	{
		alert("Preencha o campo 'FONE'")
		frmContato.fone.focus()
		return false
	}else if(cpf === ""){
		alert("Preencha o campo 'CPF'")
		frmContato.cpf.focus()
		return false
	}else if(produto === ""){
		alert("Preencha o campo 'PRODUTO'")
		frmContato.produto.focus()
		return false
	}else if(dia === ""){
		alert("Preencha o campo 'DIA'")
		frmContato.dia.focus()
		return false
	}else{
		document.forms["frmContato"].submit()
		alert("Arquivo salvo com sucesso!!!")
	}
}