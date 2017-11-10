function stringSlice() {
	var destintion = document.getElementById("input").value;
	var desLoc = destintion.split(" ");
	document.getElementById("map").innerHTML = desLoc;
	var s = "";
	for (var i = 0; i < destintion.length-1; i++) {
			s = destintion[i] + "+";
		
		
	}
	var url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
			+"&destinations="+ s + "&key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y";
}