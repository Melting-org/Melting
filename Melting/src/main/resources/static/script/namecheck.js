/**
 * jquary ajax를 이용해 닉네임 중복확인 체크 
 */

 $(function(){
	$("#membername").keyup(function() {
		let mid = $(this).val();
		if(mid.trim().length == 0 ) {
			$("#checkResult2").css("color" , "red");
			$("#checkResult2").text('닉네임을 입력하세요');
			return false;	
		} 
		$("#checkResult2").css("color", "blue");
		$("#checkResult2").text('형식 맞음');
		
		$.ajax({
			method : "GET"
			, url : "nameCheck"
			, data : {"membername" : mid}
			, success : function(resp) {	
				if(resp == "OK") {  
					$("#checkResult2").css("color", "blue");
					$("#checkResult2").text('사용가능한 닉네임입니다.');
				} else if(resp == "FAIL") {
					$("#checkResult2").css("color", "red");
					$("#checkResult2").text('이미 사용중인 닉네임입니다.');
				}
			}
		})
	})
})