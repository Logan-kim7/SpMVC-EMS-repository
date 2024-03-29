<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	document.addEventListener("DOMContentLoaded", function() {
		
		document.querrySelector("#bbs-writer")
				.addEventListener("click", function(){
						document.location.href = "${rootPath}/ems/write"
				})
				
		document.querySelector("table").addEventListener("click", function(event){
			let tag_name = event.target.tagName;
			if(tag_name === "TD"){
				
				let seq = event.target.closest("TR").dataset.seq
				if(seq){
					document.location.href = "${rootPath}/bbs/detail/" + seq	
				}
			}
			
			
		});
		
	})

</script>
<style>
</style>

<table class="">
	<thead>
		<tr>
			<th>발송 Email</th>
			<th>받는 Email</th>
			<th>발송일자</th>
			<th>발송시각</th>
			<th>메일제목</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty EMS_LIST}">
			<tr><td colspan="5">데이터가 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${EMS_LIST}" var="vo" varStatus="i">
			<tr class="ems-tr" data-seq="${vo.s_seq}">
				<td>${i.count}</td>
				<td>${vo.s_data}</td>
				<td>${vo.s_time}</td>
				<td>${vo.s_writer}</td>
				<td data-seq="${vo.s_seq}" class="bbs-subject">
						${vo.s_subject} 
				</td>
				<td>${vo.s_subject}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="button-box">
		<button id="ems-write">메일작성 하기</button>
</div>
