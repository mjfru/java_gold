<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/styles.css"/>
<title>Java Gold Game</title>
</head>
<body>
	<h1>Java Gold</h1>
	<p>Your Gold: <c:out value="${gold}"/></p>
	<table>
		<tbody>
			<tr>
				<td>
					<h4>Farm</h4>
					<p>[Earn 10 - 20 Gold]</p>
					<form action="/" method="POST">
						<input class="button" type="submit" name="farm" value="Find Gold" />
					</form>
				</td>
				<td>
					<h4>Cave</h4>
					<p>[Earn 5 - 10 Gold]</p>
					<form action="/" method="POST">
						<input class="button" type="submit" name="cave" value="Find Gold" />
					</form>
				</td>
				<td>
					<h4>House</h4>
					<p>[Earn 2 - 5 Gold]</p>
					<form action="/" method="POST">
						<input class="button" type="submit" name="house" value="Find Gold" />
					</form>
				</td>
				<td>
					<h4>Quest</h4>
					<p>[Earn/Lose 0 - 50 Gold]</p>
					<form action="/" method="POST">
						<input class="button" type="submit" name="quest" value="Begin Quest" />
					</form>
				</td>
				<td>
					<h4>Spa</h4>
					<p>[Lose 5-20 Gold]</p>
					<form action="/" method="POST">
						<input class="button" type="submit" name="spa" value="Relax..."/>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
	<h3>Activities:</h3>
	<iframe src="/activities" title="Activities IFrame"></iframe>
	<a href="/reset">Reset Game</a>
</body>
</html>