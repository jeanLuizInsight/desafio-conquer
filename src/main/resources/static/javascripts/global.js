//---------- Loading -----------------
var titleDoc;
function loading(vtxt) {
	var txt = vtxt;
	titleDoc = document.title;
	_loading();
	var dot = 1;
	
	function _loading() {
		if ($('#loading-div').length == 0) {
			criarDivLoading();
		}
		$('#loading-div div:first').addClass('spinner');
		if (txt != null && !isObject(txt)) {
			$('#loadSpan').html('<div id="primeiraMsg">' + txt + '</div><div id="segundaMsg"></div>');
		} else {
			$('#loadSpan').html('<div id="primeiraMsg">Processando, aguarde ...</div><div id="segundaMsg"></div>');
		}
		
		$('#loading-div').show();
		
		countLoad = 0;
		if (txt == null) {
			setTimeout(function(){countLoading();}, 1000);
		}
		setTimeout(titleAnimacao, 500);
	}

	function criarDivLoading() {
		var div = document.createElement("DIV");
		div.id = 'loading-div';
		div.className = 'loading-conquer';
		div.style.display = 'none';
		div.innerHTML = '<div></div><span style="height: auto;" id="loadSpan" ></span><div class="loading-fundo"></div>';
		document.body.appendChild(div);
	}
	
	function titleAnimacao() {
		if (titleDoc == null) {
			return;
		}
		var titleTemp = 'Processando';
		dot++;
		dot = dot % 4;
		if (dot == 1) {
			titleTemp = titleTemp + '.';
		} else if (dot == 2) {
			titleTemp = titleTemp + '..';
		} else if (dot == 3) {
			titleTemp = titleTemp + '...';
		}
		document.title = titleTemp;
		setTimeout(titleAnimacao, 500);
	}
	
	function countLoading() {
		if ($('#segundaMsg').length  == 0) {
			return;
		}
		countLoad++;
		//15 segundos de espera
		if (countLoad >= 15) {
			$('#segundaMsg').html('Desculpe a demora, est&aacute quase terminando.')
			return;
		}
		setTimeout(function(){countLoading();}, 1000);
	}
}	

function endLoading(){
	if (titleDoc != null) {
		document.title = titleDoc;
		titleDoc = null;
	}
	$('#loading-div').remove();
}
// ------------------------- end loading --------------------------