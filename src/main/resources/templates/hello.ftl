<html>
<head>
    <title>Freemarker初体验</title>
</head>
<body>
<div>
    <h1>插值的应用</h1>
    <ul>
        <li>基本类型：${num1}</li>
        <li>基本类型：${num1*2}</li>
        <li>引用类型：${str1}</li>
        <li>引用类型：${company.name}</li>
    </ul>
</div>
<div>
    <h1>指令应用</h1>
    <#if level=='P5'>
        <h2 style="color: green">中级：7-10K</h2>
    <#elseif level=='P7'>
        <h1 style="color: red">初级：12K-15K</h1>
    <#elseif level=='P6'>
        <h1 style="color: red">高级：9K-13K</h1>
    </#if>
    <ul>
        <#list companylist as c>
            <li>序号：${c.id} ，名称：${c.name}，人数：${c.nums}</li>
        </#list>

    </ul>
</div>
</body>
</html>