function rane_setCookie(name, value) {
  var cookieString = name + "=" +escape(value) + ";path=/";
  document.cookie = cookieString;
} 
