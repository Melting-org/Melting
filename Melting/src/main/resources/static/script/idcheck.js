/**
 * jquary ajax를 이용해 id 중복확인 체크 
 */

$(function(){
	$("#memberid").keyup(function() {
		let mid = $(this).val();
		if(mid.trim().length < 3 || mid.trim().length > 10 ) {
			$("#checkResult").css("color" , "red");
			$("#checkResult").text('아이디는 3~10자');
			return false;	
		} 
		$("#checkResult").css("color", "blue");
		$("#checkResult").text('형식 맞음');
		
		$.ajax({
			method : "GET"
			, url : "idCheck"
			, data : {"memberid" : mid}
			, success : function(resp) {	
				if(resp == "OK") {  
					$("#checkResult").css("color", "blue");
					$("#checkResult").text('사용가능한 아이디입니다.');
				} else if(resp == "FAIL") {
					$("#checkResult").css("color", "red");
					$("#checkResult").text('사용할 수 없는 아이디입니다.');
				}
			}
		})
	})
})

function fn_idChk(){
			$.ajax({
				url : "./idChk",
				type : "GET",
				dataType : "html",
				data : {"memberid" : $("#memberid").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				}
			})
		}