<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Log Viewer</title>
</head>

<body>
    <form class="form-inline">
        <fieldset>
            <g:select name="application" from="${weblog.applications(collection: 'applications')}" />
            <g:select name="level" from="${weblog.loglevels()}" />
            <button type="submit" class="btn btn-primary">Go!</button>
        </fieldset>
    </form>

    <div>

    </div>

    <table class="table table-condensed ">
        <thead>
            <tr>
                <th>Date</th>
                <th>Application</th>
                <th>Level</th>
                <th>Classname</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <g:each var="item" in="${page.items}">
                <tr>
                    <g:set var="fields" value="${item['@fields']}" />
                    <td>${item.get("@timestamp")}</td>
                    <td>${fields["applicationName"][0]}</td>
                    <td>${fields["loglevel"][0]}</td>
                    <td>${fields["classname"][0]}</td>
                    <td>${fields["text"][0]}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
</html>