<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<jsp:include page="../component/header.jsp" />
<div id="content">
    <div id="nav">
        <a href="#">Danh mục tin tức</a> | 
        <a href="AddNewsController">Thêm tin tức mới</a> | 
        <a href="AdminController">Chức năng quản lý</a>
    </div>
    <div id="news">
        <table id="tablenew">
            <tr>
                <th>Tên danh mục</th>
                <th>Mô tả</th>
                <th>Tin tức</th>
                <th>Ghi chú</th>
            </tr>
            <c:forEach items="${danhMucs}" var="itemsDM">
                <tr>
                    <td>
                        ${itemsDM.tenDM}
                    </td>
                    <td>${itemsDM.moTa}</td>
                    <td>
                    	<ul>
                            <c:forEach items="${tinTucs}" var="itemsTT">
                                <c:if test="${itemsTT.maDM == itemsDM.maDM}">
                                    <li>${itemsTT.tieuDe}</li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>${itemsDM.ghiChu}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../component/footer.jsp" />