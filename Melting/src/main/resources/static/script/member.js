 function validation() {
	 let memberid = document.getElementById("memberid");
	 let memberpwd  = document.getElementById("memberpwd");
	 let memberpwd2  = document.getElementById("memberpwd2");
	 let membername = document.getElementById("membername");
	 
	 if(memberid.value.trim().length < 3 || memberid.value.trim().length > 10) {
		 alert("ID는 3~10자 사이로 입력하세요");
		 memberid.focus();	
		 memberid.select();	
		 return false;
	 }
	 
	 if(memberpwd.value.trim().length < 3 || memberpwd.value.trim().length > 10) {
		 alert("비밀번호는 3~10자 사이로 입력하세요");
		 memberpwd.focus();
		 memberpwd.select();
		 return false;
	 }
	 
	 if(memberpwd2.value.trim() !== memberpwd.value.trim()) {	
		 alert("비밀번호를 정확히 입력하세요");	
		 memberpwd2.focus();	
		 memberpwd2.select();	
		 return false;
	 }

	 
	 if(membername.value.trim().length == 0) {
		 alert("이름을 입력하세요");
		 membername.focus();
		 membername.select();
		 return false;
	 }

	 return true;
 }