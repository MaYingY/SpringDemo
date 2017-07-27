<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-7-27
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${prouct.name}<br>
        Description: ${product.description}<br>
        Price: ${product.price}
    </p>
</div>

</body>
</html>
