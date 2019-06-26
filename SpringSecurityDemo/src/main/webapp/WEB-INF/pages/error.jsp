<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="includes/meta-data.jsp" flush="true" />
	<!-- Load CSS -->
	<jsp:include page="includes/style.jsp" flush="true" />
	<!-- Include External CSS -->
	<jsp:include page="includes/script.jsp" flush="true" />
	<jsp:include page="includes/other-script.jsp" flush="true" />
	<!-- <script src="//cdn.tinymce.com/4/tinymce.min.js"></script> -->
</head>
<body>
	<div id="page-wapper" class="site-holder">
		<!-- this is a dummy text -->
		<!-- .navbar -->
		<jsp:include page="includes/header.jsp" flush="true" />
		<!-- /.navbar -->
		<!-- .box-holder -->
		<div class="box-holder">
			<!-- .left-sidebar -->
			<!-- /.left-sidebar -->
			<!-- .content -->
			<div class="row">
				<div class="col-md-12 text-center">
					<h3>Something Got Wrong...</h3>
				</div>
			</div>
				<!-- Form elements -->
			<!-- /.content -->
			<!-- .right-sidebar -->
			<div class="right-sidebar right-sidebar-hidden">
				<div class="form-group backgroundImage hidden">
					<label class="control-label">Paste Image Url and then hit enter</label> <input type="text" class="form-control"
						id="backgroundImageUrl" />
				</div>
			</div>
			<!-- /.right-sidebar-holder -->
		</div>
		<!-- /.right-sidebar -->
	</div>
	<!-- /.box-holder -->
</body>
</html>