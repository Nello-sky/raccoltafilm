

function validateRegista() {

	// catturo le variabili di controllo, le mando tutte in UpperCase...
	let nome = document.getElementById("nome");
	var checkNome = document.getElementById("checkNome");

	let cognome = document.getElementById("cognome");
	var checkCognome = document.getElementById("checkCognome");
	let nickName = document.getElementById("nickName");
	var checkNickName = document.getElementById("checkNickName");
	let dataDiNascita = document.getElementById("dataDiNascita");
	var checkDataNascita = document.getElementById("checkDataNascita");
	var sesso = document.getElementById("sesso");
	var checkSesso = document.getElementById("checkSesso");

	//check void arguments
		if (sesso.value.trim() == "") {
		sesso.focus();
		sesso.style.border = "3px solid red";
		sesso.style.background = "Bisque ";
		checkSesso.innerHTML = "! va selezionato il sesso!";

	}
	else {
		sesso.style.border = "3px solid green";
		sesso.style.background = "LightCyan ";
		checkSesso.innerHTML = "";
	}
	
	if (dataDiNascita.value.trim() == "") {
		dataDiNascita.focus();
		dataDiNascita.style.border = "3px solid red";
		dataDiNascita.style.background = "Bisque ";
		checkDataNascita.innerHTML = "! va inserita una data !";

	}
	else {
		dataDiNascita.style.border = "3px solid green";
		dataDiNascita.style.background = "LightCyan ";
		checkDataNascita.innerHTML = "";
	}

	if (nickName.value.trim() == "") {
		nickName.focus();
		nickName.style.border = "3px solid red";
		nickName.style.background = "Bisque ";
		checkNickName.innerHTML = "! va inserito un nickname !";

	}
	else {
		nickName.style.border = "3px solid green";
		nickName.style.background = "LightCyan ";
		checkNickName.innerHTML = "";
	}

	if (cognome.value.trim() == "") {
		cognome.focus();
		cognome.style.border = "3px solid red";
		cognome.style.background = "Bisque ";
		checkCognome.innerHTML = "! va inserito un cognome !";

	}
	else {
		cognome.style.border = "3px solid green";
		cognome.style.background = "LightCyan ";
		checkCognome.innerHTML = "";
	}

	if (nome.value.trim() == "") {
		nome.focus();
		nome.style.border = "3px solid red";
		nome.style.background = "Bisque ";
		checkNome.innerHTML = "! va inserito un nome !";

	}
	else {
		nome.style.border = "3px solid green";
		nome.style.background = "LightCyan ";
		checkNome.innerHTML = "";
	}





	if (nome.value.trim() == "" || cognome.value.trim() == "" || nickName.value.trim() == "" || dataDiNascita.value.trim() == "" || sesso.value.trim() == "") {
		return false;
	}



}