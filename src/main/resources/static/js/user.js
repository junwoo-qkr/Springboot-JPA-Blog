let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},
	save: function() {
		// alert('user의 save 함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		// console.log(data);
		
		// ajax 호출 시 default는 비동기 호출
		$.ajax({ // 회원가입 수행 요청
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body 데이터 -> MIME 타입 필요
			contentType: "application/json; charset = utf-8", // body 데이터 타입 (요청)
			dataType: "json" // 응답 데이터를 자바스크립트 형식으로 변환 (없어도 됨)
		}).done(function(response) { // 요청 성공 시
			// alert(response);
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function() { // 요청 실패 시
			alert(JSON.stringify(error));
		}); // ajax 통신으로 3개의 데이터를 json으로 변경하여 insert 요청
	}
}

index.init();