document.getElementById("submitGlyph").addEventListener("click",function(){
	
document.getElementById("nextDeal").innerHTML='<input id="dealType" placeholder="Deal\'s Type"> <input'+
	'id="description" placeholder="Description"> <input id="price"'+
	'placeholder="Price"> <input id="startTime"'+
	'placeholder="Start Time"> <input id="endTime"'+
	'placeholder="End Time"> <span id="submitGlyph"'+
	'class="glyphicon glyphicon-plus-sign"></span>';
		

	alert("hello");

});

document.getElementById("submitGlyph").addEventListener("click",function(){
	node=document.createTextNode('<input id="dealType" placeholder="Deal\'s Type"> <input'+
	'id="description" placeholder="Description"> <input id="price"'+
	'placeholder="Price"> <input id="startTime"'+
	'placeholder="Start Time"> <input id="endTime"'+
	'placeholder="End Time"> <span id="submitGlyph"'+
	'class="glyphicon glyphicon-plus-sign"></span>');
	document.getElementById("nextDeal").appendchild(node);

	alert("hello");

});