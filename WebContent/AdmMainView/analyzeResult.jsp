<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>统计结果</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
<script type="text/javascript" src="js/exporting.js"></script>
<script type="text/javascript" src="js/export-data.js"></script>
<script type="text/javascript">
    $(function(){
        $("#container").highcharts({    //图表展示容器，与div的id保持一致
            chart: {
                type:'column',    //指定图表的类型，默认是折线图（line）
            },
            title: {
                text:'统计结果', //指定图表标题
            },
            xAxis: {
                categories: ['问题1', '问题2', '问题3','问题4','问题5'], //指定X分组
            },
            yAxis: {
                title: {
                    text:'答案个数', //指定Y轴的标题
                },
            },
            tooltip: {
                crosshairs: true,
                shared: true,
                headerFormat: '<b>{point.key}</b><br>',
                pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y} / {point.stackTotal}'
            },
            lang: {
				printChart : "打印图表",
				downloadJPEG : "下载JPEG 图片",
				downloadPDF : "下载PDF文档",
				downloadPNG : "下载PNG图片",
				downloadSVG : "下载SVG矢量图",
				downloadXLS : "下载XLS表格",
				downloadCSV : "下载CSV文件",
				viewData: '查看数据表格',
				openInCloud: '在云中打开'
			},
			exporting: {
				filename: '统计结果'
            },
			series : <%=request.getAttribute("data")%>,
		});
	});
    /* function refresh(){
		$.ajax({
			type:"post",
			url:"../AnalyzeQuestionnaireByIdServlet",
			dataType : 'json',
			success:function(data){
				console.log(data);
				var aa={"data":[1,2,6,1,6],"name":"A"};
				 $('#container').highcharts().series[0].update(aa);
			}
		});
	} */
</script>
</head>
<body>
<div id="container" style="width: 900px; height: 470px;"></div>
<!-- <input type="button" id="query" value="刷新" onclick="refresh()"> -->
</body>
</html>