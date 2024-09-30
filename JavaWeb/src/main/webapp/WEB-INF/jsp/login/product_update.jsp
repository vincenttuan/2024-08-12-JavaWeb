<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Update</title>
	</head>
	<body>
		<form method="post" enctype="multipart/form-data" action="/JavaWeb/product/add">
			<fieldset>
				<legend>商品新增</legend>
				商品名稱: <input type="text" name="product_name" placeholder="請輸入商品名稱" required /><p />
				商品價格: <input type="number" name="price" placeholder="請輸入商品價格" required /><p />
				商品庫存: <input type="text" name="stock_quantity" placeholder="請輸入商品庫存" required /><p />
				商品圖片: <input type="file" name="product_image" placeholder="請選擇商品圖片" /><p />
				<button type="submit">新增</button>
			</fieldset>
		</form>
	</body>
</html>