/*js模块化*/
var ajax = (function(){
	
	function createXmlHttp() {
		
		var xmlHttp;
		// 浏览器兼容，判断是否为IE8以下
		if(window.ActiveXObject) {
			// 获得ajax引擎对象
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			// 获得ajax引擎对象
			xmlHttp = new XMLHttpRequest();
		}
		
		return xmlHttp;
	}
	
	var ajax = {
			"createXmlHttp" : createXmlHttp
	}
	
	return ajax;
})();