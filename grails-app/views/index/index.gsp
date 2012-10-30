<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Log Viewer</title>
</head>

<body>

    <div class="hero-unit">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
    </div>

    <h2>Summary</h2>
    <div class="row">
        <div class="span4">
            <h3>Access</h3>
            <g:set var="logSummary" value="${logsSummaries['Access']}"/>
            <p><g:formatNumber number="${logSummary.count}" type="number"/> logs since <g:formatDate date="${logSummary.startDate}" format="yyyy-MM-dd HH:mm:ss"/></p>
        </div>

        <div class="span4">
            <h3>Application</h3>
            <g:set var="logSummary" value="${logsSummaries['Application']}"/>
            <p><g:formatNumber number="${logSummary.count}" type="number"/> logs since <g:formatDate date="${logSummary.startDate}" format="yyyy-MM-dd HH:mm:ss"/></p>
        </div>

        <div class="span4">
            <h3>Catalina</h3>
            <g:set var="logSummary" value="${logsSummaries['Catalina']}"/>
            <p><g:formatNumber number="${logSummary.count}" type="number"/> logs since <g:formatDate date="${logSummary.startDate}" format="yyyy-MM-dd HH:mm:ss"/></p>
        </div>
    </div>

</body>
</html>