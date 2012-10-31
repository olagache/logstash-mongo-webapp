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
            <g:select name="level" from="${weblog.loglevels(collection: 'applications')}" />
            <button type="submit" class="btn btn-primary">Go!</button>
        </fieldset>
    </form>

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
    </table>
</body>
</html>