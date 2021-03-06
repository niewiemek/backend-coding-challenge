<!DOCTYPE html>
<html>
	<head>
		<title>
			EngageTech - Back End Coding Test
		</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<meta http-equiv="content-language" content="en-gb" />
		<link rel="icon" type="image/x-icon" href="/favicon.ico" />
		<link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
		<link name="apple-mobile-web-app-capable" content="yes" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="/css/engage.main.min.css" />
		<script type="text/javascript" src="/js/shared.min.js"></script>
		<script type="text/javascript" src="/js/codingtest.min.js"></script>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<div id="header">
			<ng-include src=" 'shared/navbar.html' "></ng-include>
			<ng-include src=" 'shared/navbar-subbar.html' "></ng-include>
		</div>
		<div id="tab-header">
			<ng-include src=" 'shared/tab-header.html' "></ng-include>
		</div>
		<div id="content">
			<ng-view class="slide-view"></ng-view>
		</div>
	</body>
</html>
