<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		$(".deleteId").click(function() {

			var $url = this.href;

			//alert($url);

			$("#deleteForm").attr("action", $url);

			//提交表单

			$("#deleteForm").submit();

			return false;

		});

	});
</script>

</head>
<body>
	<div class="container">
		<h1 align="center">动漫人物列表页</h1>
		<hr width="1000px">
		<table class="table table-bordered table-hover table-striped">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>生日</th>
				<th>上映时间</th>
				<th>所属电影</th>
				<th>点击删除</th>
				<th>点击修改</th>
			</tr>

			<c:forEach items="${pb.beanList }" var="m">
				<tr>
					<td>${m.monsterId }</td>
					<td>${m.mname }</td>
					<td>${m.email }</td>
					<td><fmt:formatDate value="${m.birthday }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${m.entryday }"
							pattern="yyyy-MM-dd" /></td>
					<td>${m.schools.name }</td>
					<td><a href="http://localhost/ssm/monster/${m.monsterId }"
						class="deleteId btn btn-danger">删除</a></td>
					<td><a href="http://localhost/ssm/monster/${m.monsterId }"
						class="btn btn-primary">修改</a></td>
				</tr>
			</c:forEach>
		</table>

		<!-- 准备一个隐藏表单 -->
		<form action="" method="post" id="deleteForm">
			<input type="hidden" name="_method" value="DELETE" />
		</form>

		<!-- 分页 -->
		<center>
			<p>第${pb.pageNow }页/共${pb.pages }页</p>
			<ul class="pagination">
				<li><a href="1">首页</a></li>
				<%-- <li><c:if test="${pb.pageNow>1 }">
				<a href="${pb.pageNow-1 }">上一页</a>
			</c:if></li> --%>

				<c:choose>
					<c:when test="${pb.pages<=10 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="${pb.pages }"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${pb.pageNow-5 }"></c:set>
						<c:set var="end" value="${pb.pageNow+4 }"></c:set>
						<c:if test="${begin<=1 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="10"></c:set>
						</c:if>
						<c:if test="${end>=pb.pages }">
							<c:set var="begin" value="${pb.pages-9 }"></c:set>
							<c:set var="end" value="${pb.pages }"></c:set>
						</c:if>
					</c:otherwise>
				</c:choose>
				<!-- 循环十个数 -->
				<c:forEach begin="${begin }" end="${end }" var="i">
					<c:choose>
						<c:when test="${pb.pageNow==i }">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><span><a href="${i }">${i }</a></span></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				<%-- <li><c:if test="${pb.pageNow<pb.pages }">
				<a href="${pb.pageNow+1 }">下一页</a>
			</c:if></li> --%>

				<li><span><a href="${pb.pages }">尾页</a></span></li>

			</ul>

		</center>
		</br>
		<p align="center">
			<a href="http://localhost/ssm/addUI">没有找到人物？去添加一个</a>
		</p>
	</div>
</body>
</html>