<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Log Viewer</title>
</head>

<body>
    <form class="form-inline" method="get">
        <fieldset>
            <g:select name="application" from="${weblog.applications(collection: 'access')}" value="${page?.query?.applicationName}"/>
            <g:select name="responseCode" from="${weblog.responseCode()}" value="${page?.query?.responseCode}"/>
            <input type="hidden" name="max" value="50">
            <input type="hidden" name="offset" value="0">
            <button type="submit" class="btn btn-primary">Go!</button>
        </fieldset>
    </form>

    <div class="alert alert-info">
        <h4>Statistic results:</h4>
        <p>Nb result: ${page.totalCount} , page ${page.query.index + 1} of ${page.pageCount}</p>
    </div>

    <div class="row">
        <div class="span12" style="text-align: center">
            <g:paginate total="${page.totalCount}"
                        params="[application : page?.query?.applicationName, responseCode : page?.query?.responseCode]"
                        action="index"/>
        </div>
    </div>

    <table class="table table-condensed ">
        <thead>
            <tr>
                <th>Date</th>
                <th>Application</th>
                <th>Response</th>
                <th>Client IP</th>
                <th>Request</th>
            </tr>
        </thead>
        <tbody>
            <g:each var="item" in="${page.items}">
                <tr>
                    <g:set var="fields" value="${item['@fields']}" />
                    <td style="white-space: nowrap" >
                        <small>${item.get("@timestamp")}</small>
                    </td>
                    <td>
                        <g:if test="${fields.applicationName}">
                            <small>${fields.applicationName[0]}</small>
                        </g:if>
                    </td>
                    <td>
                        <g:if test="${fields.response}">
                            <small>${fields.response[0]}</small>
                        </g:if>
                    </td>
                    <td>
                        <g:if test="${fields.clientip}">
                            <small>${fields.clientip[0]}</small>
                        </g:if>
                    </td>
                    <td>
                        <g:if test="${fields.request}">
                            <small>${fields.request[0]}. <g:link controller="logDetails" params="[collectionName : page.query.mongoCollection, id : item['_id']]" class="btn btn-info btn-mini pull-right" rel="external">details</g:link>
                            </small>
                        </g:if>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>

    <div class="row">
        <div class="span12" style="text-align: center">
            <g:paginate total="${page.totalCount}"
                        params="[application : page?.query?.applicationName, responseCode : page?.query?.responseCode]"
                        action="index"/>
        </div>
    </div>

</body>
</html>