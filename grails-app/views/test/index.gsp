<h1>Logs Summaries</h1>


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
