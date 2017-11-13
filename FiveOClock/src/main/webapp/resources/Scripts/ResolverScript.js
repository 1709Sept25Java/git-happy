function postPending(xhr){
	var res = xhr.responseText;
	res=res.substring(1, res.length -1);
	res="{"+res+"}";
	res=JSON.parse(res);
	table = document.getElementById("resolverTable");
	console.log(res);
	console.log("got data");
}


function sendAjax(url, func) {
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
window.onload=function(){
	sendAjaxGet('http://ec2-18-220-223-179.us-east-2.compute.amazonaws.com:8080/FiveOClock/deals', postPending);
}
