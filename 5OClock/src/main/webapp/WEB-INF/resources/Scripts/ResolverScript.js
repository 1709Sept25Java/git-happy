function getResolved(xhr){
	var res = xhr.responseText;
	res=res.substring(1, res.length -1);
	res="{"+res+"}";
	res=JSON.parse(res);
	table = document.getElementById("resolverTable");
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
	sendAjax("http://localhost:8082/5OClock/resolvers", getResolved);
}