<h1>Logs Summaries</h1>



<g:each in="${logsSummaries.entrySet()}" var="entry">
    <div>
        <h2>${entry.key} Logs</h2>
        <g:set var="logSummary" value="${entry.value}"/>
        <table border="1" cellspacing="0" cellpadding="5">
            <thead>
            <tr>
                <th>Application Names</th>
                <th>Count</th>
                <th>First date</th>
                <th>Last date</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <g:each var="name" in="${logSummary.applicationNames}">${name}<br></g:each>
                </td>
                <td>${logSummary.count}</td>
                <td><g:formatDate date="${logSummary.startDate}" format="yyyy-MM-dd HH:mm:ss"/> </td>
                <td><g:formatDate date="${logSummary.endDate}" format="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            </tbody>
        </table>
    </div>
</g:each>


<h2>Logs</h2>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th nowrap>Date</th>
        <th nowrap>Application</th>
        <th nowrap>Level</th>
        <th nowrap>Classname</th>
        <th nowrap>text</th>
    </tr>
    <g:each var="appLog" in="${applicationLogs}">
        <tr>
            <td nowrap>${appLog.timestamps}</td>
            <td nowrap>${appLog.fields["applicationName"]}</td>
            <td nowrap>${appLog.fields["loglevel"]}</td>
            <td nowrap>${appLog.fields["classname"]}</td>
            <td nowrap>${appLog.fields["text"]}</td>
        </tr>
    </g:each>
</table>
