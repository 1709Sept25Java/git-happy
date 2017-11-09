window.onload = sendAjaxGet( 'http://localhost:8082/FiveOClock/deals', consoleLogObject);

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function consoleLogObject(xhr){
		var res = xhr.responseText;
		console.log(res);
}