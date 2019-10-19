<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<body>
	<h1>Available Books</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>author</th>
				<th>title</th>
				<th>rented till</th>
				<th colspan="3">options</th>
			</tr>
		</thead>

		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.author}</td>
				<td>${book.title}</td>
				<td>${book.rentedTill}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>