<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    #bangDeTai {
        border: 1px solid black;
        width: 100%;
    }
    tr, th, td {
        border: 1px solid black;
    }
    th:nth-child(1) {
        width: 240px; /* Adjust this value as needed */
    }
    th:nth-child(2) {
        width: 400px; /* Adjust this value as needed */
    }
</style>
<body>
	<div id="main">
        <h1>Đăng ký đề tài</h1>

        <table id="bangDeTai">
            <tr>
                <th>Faculty</th>
                <th>
                    Full Name
                </th>
                <th>Reseach Area</th>
                <th>Telephone Number</th>
            </tr>

            <tr>
                <td>Information Technology</td>
                <td>Nguyen Van A</td>
                <td>Machine Learning</td>
                <td>0123456789</td>
            </tr>
            
           <c:forEach items="${giaoVienList}" var="item" >
				<tr>
					<td>
					    <c:out value="${item.maGiangVien}"/>
					</td>
					<td>
						<c:out value="${item.tenGiangVien}"></c:out>
						<br><u><i>Danh sách đề tài</i></u></br>
						<ul>
 							<c:forEach items="${deTaiList}" var="detaiItem">
                                <c:if test="${detaiItem.giangVien.maGiangVien == item.maGiangVien}">
                                    <li>
                                        <c:out value="${detaiItem.tenDeTai}"></c:out>
                                    </li>
                                </c:if>
                            </c:forEach>
						</ul>
					<td>
						<c:out value="${item.linhVucNghienCuu}"></c:out>
					</td>
					<td>
					    <c:out value="${item.soDienThoai}"></c:out>
					</td>
				</tr>
			</c:forEach>
            
        </table>
    </div>
</body>
</html>