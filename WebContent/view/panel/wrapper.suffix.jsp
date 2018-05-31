<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%boolean isAjax = com.appcore.util.AjaxUtil.checkIsAjax(request);%>
<c:if test="${isAjax != true}">

<jsp:include page="/view/panel/inc/footer.jsp"/> 

</body>
</html>


</c:if> 