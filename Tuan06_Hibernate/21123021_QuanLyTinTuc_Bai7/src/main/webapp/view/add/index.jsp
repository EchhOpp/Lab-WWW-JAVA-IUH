<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<jsp:include page="../component/header.jsp" />

<style>
    #addnews {
        margin: 0 auto;
        width: 50%;
    }
</style>
<div id="content">
    <div id="nav">
        <a href="HomeController">Danh mục tin tức</a> | 
        <a href="#">Thêm tin tức mới</a> | 
        <a href="AdminController">Chức năng quản lý</a>
    </div>
    <div id="addnews">
        <form action="AddNewsController" method="get">
            <table>
                <tr>
                    <td>Mã tin tức</td>
                    <td><input type="text" name="maTT" required></td>
                </tr>
                <tr>
                    <td>Tiêu đề</td>
                    <td><input type="text" name="tieuDe" required></td>
                </tr>
                <tr>
                    <td>Nội dung</td>
                    <td><input name="noiDungTT" required></textarea></td>
                </tr>
                <tr>
                    <td>Liên kết</td>
                    <td><input type="text" name="lienKet" required></td>
                </tr>
                <tr>
                    <td>Mã danh mục</td>
                    <td>
                        <select name="maDM">
                            <c:forEach items="${danhMucs}" var="itemsDM">
                                <option value="${itemsDM.maDM}">${itemsDM.tenDM}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Thêm" id="add">
                        <input type="reset" value="Nhập lại" id="reset"></td>
                    </td>
					<c:if test="${not empty message}">
						<script>
							alert("${message}");
						</script>
					</c:if>
				</tr>
            </table>
    </div>
</div>

<jsp:include page="../component/footer.jsp" />