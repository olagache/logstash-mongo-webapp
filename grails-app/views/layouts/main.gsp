<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Log Viewer"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

		<g:layoutHead/>

        <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
        </style>

        <r:require module="bootstrap"/>
        <r:require module="jquery"/>
		<r:layoutResources />
	</head>
	<body>
        <!-- NavBar -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <g:link class="brand" controller="index">Log Viewer</g:link>

                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><g:link controller="access">Access Log</g:link></li>
                            <li><g:link controller="application">Application Log</g:link></li>
                            <li><a href="#">Catalina Log</a></li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>

        <div class="container">
            <g:layoutBody/>
        </div>


        <g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
