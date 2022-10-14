<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학과 조회</title>

    <style>
        table{border-collapse : collapse;}
        thead th{
            background-color : lightgray;
            padding: 5px 30px;    
        }
        tbody td{text-align : center;}
        tbody > tr:nth-child(2n) td{background-color : #ddd;}
        tbody > tr:hover td{
            background-color : #b1afff;
            cursor : pointer;
        }
    </style>
</head>
<body>
    
    <h3>
        학과명 : ${param.inputDept}
    </h3>

    <table>
        <thead>
            <tr>
                <th>학번</th>
                <th>이름</th>
                <th>학과</th>
                <th>주소</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${stdList}">
                <tr>
                    <td>${student.studentNo}</td>
                    <td>${student.studentName}</td>
                    <td>${student.departmentName}</td>
                    <td>${student.studentAddress}</td>
                </tr>
            
            </c:forEach>        
        </tbody>

    </table>
    
</body>
</html>