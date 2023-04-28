

function validateFilm() {

	// catturo le variabili di controllo, le mando tutte in UpperCase...
	let titolo = document.getElementById("titolo");
	var checkTitolo = document.getElementById("checkTitolo");
	let genere = document.getElementById("genere");
	var checkGenere = document.getElementById("checkGenere");
	let minutiDurata = document.getElementById("minutiDurata");
	var checkDurata = document.getElementById("checkDurata");
	let dataPubblicazione = document.getElementById("dataPubblicazione");
	var checkDataPubblicazione = document.getElementById("checkDataPubblicazione");
	let regista = document.getElementById("regista.id");
	var checkRegista = document.getElementById("checkRegista");


	//check void arguments
	if (regista.value.trim() == "") {
		regista.focus();
		regista.style.border = "3px solid red";
		regista.style.background = "Bisque ";
		checkRegista.innerHTML = "! va selezionato il regista!";

	}
	else {
		regista.style.border = "3px solid green";
		regista.style.background = "LightCyan ";
		checkRegista.innerHTML = "";
	}
	if (dataPubblicazione.value.trim() == "") {
		dataPubblicazione.focus();
		dataPubblicazione.style.border = "3px solid red";
		dataPubblicazione.style.background = "Bisque ";
		checkDataPubblicazione.innerHTML = "! va selezionata la data di pubblicazione!";

	}
	else {
		dataPubblicazione.style.border = "3px solid green";
		dataPubblicazione.style.background = "LightCyan ";
		checkDataPubblicazione.innerHTML = "";
	}
	if (minutiDurata.value.trim() == "") {
		minutiDurata.focus();
		minutiDurata.style.border = "3px solid red";
		minutiDurata.style.background = "Bisque ";
		checkDurata.innerHTML = "! va selezionata la durata!";

	}
	else {
		minutiDurata.style.border = "3px solid green";
		minutiDurata.style.background = "LightCyan ";
		checkDurata.innerHTML = "";
	}
	if (genere.value.trim() == "") {
		genere.focus();
		genere.style.border = "3px solid red";
		genere.style.background = "Bisque ";
		checkGenere.innerHTML = "! va selezionato il genere!";

	}
	else {
		genere.style.border = "3px solid green";
		genere.style.background = "LightCyan ";
		checkGenere.innerHTML = "";
	}
	if (titolo.value.trim() == "") {
		titolo.focus();
		titolo.style.border = "3px solid red";
		titolo.style.background = "Bisque ";
		checkTitolo.innerHTML = "! va selezionato il titolo!";

	}
	else {
		titolo.style.border = "3px solid green";
		titolo.style.background = "LightCyan ";
		checkTitolo.innerHTML = "";
	}

	if (titolo.value.trim() == "" || genere.value.trim() == "" || minutiDurata.value.trim() == "" || dataPubblicazione.value.trim() == "" || regista.value.trim() == "") {
		return false;
	}



}