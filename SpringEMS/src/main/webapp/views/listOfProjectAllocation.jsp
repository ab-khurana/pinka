<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Project Allocation</title>
</head>
<body>

	<%@include file="header.html"%>

	<table>
		<tr>
			<td><%@include file="linklist.jsp"%></td>
			<td>
				<%-- <%List list = (LinkedList)"${list}"; %> --%>

				<table border = black>
					<tr>
						<th>Project Allocation ID</th>
						<th>Project ID</th>
						<th>Project Name</th>
						<th>Employee ID</th>
						<th>Designation</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Status</th>
					</tr>
					<c:forEach items="${list}" var="object">
						<tr>
							<td><c:out value="${object.projectAllId}">
								</c:out></td>

							<td><c:out value="${object.projectId}"></c:out></td>
							<td><c:out value="${object.projectName}"></c:out></td>
							<td><c:out value="${object.employeeId}"></c:out></td>
							<td><c:out value="${object.designation}"></c:out></td>
							<td><c:out value="${object.startDate}"></c:out></td>
							<td><c:out value="${object.endDate}"></c:out></td>
							<td><c:out value="${object.status}"></c:out></td>
							<td><input name="edit" type='button' value='EDIT'></td>
							<td><input name="delete" type='button' value='DELETE'></td>
						</tr>
					</c:forEach>
				</table>

			</td>
		</tr>

	</table>

	<%@include file="footer.html"%>
</body>
</html>