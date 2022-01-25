---
title: Study_Spring-Web-MVC
category: Spring Web MVC
Author: Jung
---

## **Table of Contents**

---

</br>

- [**Table of Contents**](#table-of-contents)
- [**PART1**](#part1)
  - [**PART1 프로젝트 생성**](#part1-프로젝트-생성)
  - [**Section1 웹 애플리케이션 이해**](#section1-웹-애플리케이션-이해)
  - [**Section2 서블릿**](#section2-서블릿)
    - [서블릿 컨테이너](#서블릿-컨테이너)
  - [**Section3서블릿,JSP,MVC패턴**](#section3서블릿jspmvc패턴)
  - [**Section4MVC프레임워크 만들기**](#section4mvc프레임워크-만들기)
  - [**Section5스프링 MVC - 구조 이해**](#section5스프링-mvc---구조-이해)
  - [**Section6스프링 MVC - 기본 기능**](#section6스프링-mvc---기본-기능)
  - [**Section7스프링 MVC - 웹 페이지 만들기**](#section7스프링-mvc---웹-페이지-만들기)
- [**PART2**](#part2)
  - [**PART2 프로젝트 생성**](#part2-프로젝트-생성)
  - [**Section1타임리프 - 기본 기능**](#section1타임리프---기본-기능)
  - [**Section2타임리프 - 스프링 통합과 폼**](#section2타임리프---스프링-통합과-폼)
  - [**Section3메시지, 국제화**](#section3메시지-국제화)
  - [**Section4Validation**](#section4validation)
  - [**Section5Bean Validation**](#section5bean-validation)
  - [**Section6로그인 처리1 - 쿠키, 세션**](#section6로그인-처리1---쿠키-세션)
  - [**Section7로그인 처리2 - 필터, 인터셉터**](#section7로그인-처리2---필터-인터셉터)
  - [**Section8예외 처리와 오류 페이지**](#section8예외-처리와-오류-페이지)
  - [**Section9API 예외 처리**](#section9api-예외-처리)
  - [**Section10스프링 타입 컨버터**](#section10스프링-타입-컨버터)

</br>

## **PART1**

---

</br>

### **PART1 프로젝트 생성**

- Project : Gradle
- Spring boot : 2.6.2
- Language : JAVA
- Packaging : War
- JAVA ver. : 11
- Project Meta
  - Group : mvc1
  - Artifact : servlet
  - name : servlet
  - Dependencies : Spring Web, Lombok

</br>

### **Section1 웹 애플리케이션 이해**

</br>

- Web Server

  - 정적 리소스 제공(HTML, CSS, JS, image, movie 등)
  - ex) NGINX, APACHE

- WAS

  - 애플리케이션 로직
  - 웹 서버 기능 포함하지만 나눠서 관리하는 것이 효율적.

> - 웹서버 -> 정적리소스 처리
> - 애플리케이션 로직으로 동적이 처리 -> WAS위임
> - 분리 할 경우 각각의 서버 증설 관리 가능

</br>

### **Section2 서블릿**

</br>

> - HTTP 클라이언트 요청을 처리하고 다시 클라이언트에게 응답하는 servlet 클래스 구현 규칙을 지킨 자바 프로그램

</br>

- HTTP 요청 응답 프로세스

  - WAS는 Request, Response 객체 생성 후 서블릿 객체 호출
  - Request 객체에서 HTTP 요청 정보 받아서 사용
  - Response 객체에 HTTP 응답 정보 입력
  - WAS는 Reponse 객체에 담겨 있는 내용으로 HTTP 응답 정보 생성

</br>

#### 서블릿 컨테이너

</br>

> - 서블릿을 지원하는 WAS
> - 서블릿 객체 생성, 초기화, 호출, 생명주기 관리
> - 서블릿 객체를 `싱글톤`으로 관리
> - 동시 요청을 위한 `멀티 쓰레드` 처리 지원
>   - 서블릿 객체를 쓰레드가 호출함.

</br>

- servlet/src/main/java/mvc1/servlet/basic/HelloServlet.java

```java
@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    // servlet 호출 되면 service 함수 호출.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);


    }
}

```

- @WebServlet(name="helloServlet", urlPatterns = "/hello")

  - 서블릿 helloServlet으로 등록 후 /hello url로 매핑.
  - 위의 Servlet이 호출되면 service 함수 호출.

- HTTP 스펙에 맞게 헤더 설정 및 파라미터 받아오기.

</br>

- servlet/src/main/resources/application.properties

```java
logging.level.org.apache.coyote.http11=debug
```

> - 주의
>   - 개발 단계에서만 사용할 것
>   - 로그를 찍을 경우 운영상에서는 성능 문제.

</br>

### **Section3서블릿,JSP,MVC패턴**

</br>

</br>

### **Section4MVC프레임워크 만들기**

</br>

</br>

### **Section5스프링 MVC - 구조 이해**

</br>

</br>

### **Section6스프링 MVC - 기본 기능**

</br>

</br>

### **Section7스프링 MVC - 웹 페이지 만들기**

</br>

</br>
</br>
</br>

## **PART2**

---

</br>

### **PART2 프로젝트 생성**

</br>

### **Section1타임리프 - 기본 기능**

</br>

</br>

### **Section2타임리프 - 스프링 통합과 폼**

</br>

</br>

### **Section3메시지, 국제화**

</br>

</br>

### **Section4Validation**

</br>

</br>

### **Section5Bean Validation**

</br>

</br>

### **Section6로그인 처리1 - 쿠키, 세션**

</br>

</br>

### **Section7로그인 처리2 - 필터, 인터셉터**

</br>

</br>

### **Section8예외 처리와 오류 페이지**

</br>

</br>

### **Section9API 예외 처리**

</br>

</br>

### **Section10스프링 타입 컨버터**

</br>

</br>
