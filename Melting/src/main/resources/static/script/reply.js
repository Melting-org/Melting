$(function(){  
	$("#replybtn").on('click', regist);
	init();
});

// 댓글 등록
function regist() {
	let replytxt = $("#replytxt").val();
	if(replytxt.trim().length==0) {
		alert("댓글을 입력해 주세요");
		return;
	}
	
	let boardseq = $("#boardseq").val();
	
	let reply = {
		"boardseq" : boardseq,
		"replytxt": replytxt
	}
	let url = $("#contextpath").val() + "/reply/replywrite";
	
	$.ajax({
		method : "POST",
		url : url, 
		data : reply,
		success : function(resp) {
			$("#replytxt").val("");
			init();
		}
	});
}
// 댓글 목록 출력
function init() {
	let url = $("#contextpath").val() + '/reply/replylist';
	$.ajax({
		method: 'GET' ,
		url : url,
		data : { boardseq : $("#boardseq").val() },
		success: function(resp) {
			output(resp);
		},
		error : function(request, status, error) {
			console.log(status);
			console.log(error);
			console.log(request);
		}
	})
}

// 가져온 댓글 전체를 화면에 출력
function output(resp) {
	let loginID = $("#loginID").text(); 
	let url = $("#contextpath").val() ; 
	
	let data = '<table border="1">';
	$.each(resp, function(index, item) {
		data += '<tr>'
		data += '<td>' + (index+1) + '</td>' 
		data += '<td>' + item.memberid + '</td>'
		data += '<td>' + item.replytxt +'</td>'
		data += '<td>' + item.regdate + '</td>' 

		data += '<td style="width:50px">';
		
		if(loginID == item.memberid) {   
			data += '<img src="'+ url +'/images/delete.png" class="delBtn" data-sno="' + item.replyseq + '" alt="삭제" style="width:15px;cursor:pointer">';
		}
		
		data += '</td>';
		data += '</tr>'
	})
	data += '</table>'
	
	$("#replyResult").html(data); // 결과물을 출력할 위치
	$(".delBtn").on('click', delReply);
}

function delReply() {
	let replyseq = $(this).attr('data-sno');

	let url = $("#contextpath").val() + '/reply/replydelete';
	$.ajax({
		method: 'GET' ,
		url : url,
		data : { replyseq : replyseq },
		success: function() {init();}
	})
}





