<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�Խñ� �б�</h2>
[�۹�ȣ] : ${BBS_ITEM.seqno }<br/>
[������] : ${BBS_ITEM.title }<br/>
[�ۼ���] : ${BBS_ITEM.id },[�ۼ���] : ${BBS_ITEM.bbs_date }<br/>
======================================================<br/>
${BBS_ITEM.content }
</body>
</html>