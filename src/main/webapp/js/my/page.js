$(document).ready(function(){
	if(pageNum<=5) {
		$("#page ul li").eq(pageNum-1).addClass("active");
	}
	else if(pages == pageNum+2) {
		$("#page ul li").eq(5).addClass("active");
	}
	else if(pages == pageNum+1) {
		if(pageNum==6) {
			$("#page ul li").eq(5).addClass("active");
		}
		else {
			$("#page ul li").eq(6).addClass("active");
		}
	}
	else if(pages == pageNum) {
		if(pages<=7) {
			$("#page ul li").eq(pageNum-1).addClass("active");
		}
		else {
			$("#page ul li").eq(7).addClass("active");
		}
	}
	else {
		$("#page ul li").eq(4).addClass("active");
	}
})