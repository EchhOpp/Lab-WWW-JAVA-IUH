<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<jsp:include page="../component/header.jsp" />
<div id="content">
    <div id="nav">
        <a href="HomeController">Danh mục tin tức</a> | 
        <a href="AddNewsController">Thêm tin tức mới</a> | 
        <a href="#">Chức năng quản lý</a>
    </div>
    <div id="news">
        <table id="tablenew">
            <tr>
                <th>Mã danh mục</th>
                <th>Tên danh mục</th>
                <th>Mô tả</th>
                <th>Người quản lý</th>
                <th>Ghi chú</th>
                <th>Chức năng</th>
            </tr>
            <c:forEach items="${danhMucs}" var="itemsDM">
                <tr>
                    <td>${itemsDM.maDM}</td>
                    <td>
                        ${itemsDM.tenDM}
                        <br><br>
                        <b><u><i>Tin tức:</i></u></b>
                        <ul>
                            <c:forEach items="${tinTucs}" var="itemsTT">
                                <c:if test="${itemsTT.maDM == itemsDM.maDM}">
                                    <li>${itemsTT.tieuDe}</li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </td>
                    <td>${itemsDM.moTa}</td>
                    <td>${itemsDM.nguoiQL}</td>
                    <td>${itemsDM.ghiChu}</td>
                    <td>
                        <a href="#">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../component/footer.jsp" />