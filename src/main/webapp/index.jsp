<html>
<head> 
	<style> 
	
	body {
	background: #e9e9e9;
	color: #666666;
	font-family: 'RobotoDraft', 'Roboto', sans-serif;
	font-size: 14px;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	}
	
	/* Pen Title */
	.pen-title {
		padding: 200px 0;
		text-align: center;
		letter-spacing: 2px;
	}
	
	.form-module .form {
	display: none;
	padding: 40px;
	}
	
	.form-module h2 {
	margin: 0 0 20px;
	color: #33b5e5;
	font-size: 18px;
	font-weight: 400;
	line-height: 1;
	}
	
	.form-module button {
	cursor: pointer;
	background: #33b5e5;
	width: 100%;
	border: 0;
	padding: 10px 15px;
	color: #ffffff;
	}
	
	
	</style>
</head>
<body>

	<div class="pen-title">
		<div class="module form-module">
			<div class="form">
				<h2 class="align">Login to your account</h2>
					<form action="login" method="POST">
					
					    <label>Username:</label>
					    <input type="text" name="username" placeholder="Username" >
					    <br/>
					    <label>Password :</label>
					    <input type="password" name="password" placeholder="Password">
					
					    <input type="submit" value="Login"/>
					</form>
			</div>
		</div>
	</div>
</body>
</html>



