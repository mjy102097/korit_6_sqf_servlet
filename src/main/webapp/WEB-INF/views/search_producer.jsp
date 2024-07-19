<%@page import="com.study.dvd.servlet.SearchProducerServlet"%>
<%@page import="com.study.dvd.entity.Producer"%>
<%@page import="java.util.List"%>
<%@page import="com.study.dvd.dao.ProducerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td {
		border: 1px solid #dbdbdb;
		border-collapse:collapse;
	}
	
	th, td {
		padding: 5px 10px;
	}
</style>
</head>
<body>
	<div>
		<label>producer 검색</label>
		<input type="text"
			class="search_input2"
			placeholder="producer_name을 입력하세요">
		<button onclick="handleSearchClick()" >검색</button>
	</div>
	<%
		String searchText = request.getParameter("searchText");
		List<Producer> producers = ProducerDao.searchProducerByProducerName(searchText);
	%>
	<table>
		<thead>
			<tr>
				<th>Producer_ID</th>
				<th>제작사</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Producer producer : producers) {
			%>
					<tr>
						<td><%=producer.getProducer_id()%></td>
						<td><%=producer.getProducer_name()%></td>
					</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="/dvd/static/search_producer.js"></script>
</body>
</html>