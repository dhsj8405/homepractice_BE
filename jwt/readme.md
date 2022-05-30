# jwt (with spring security) 

# 의존성 추가  
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <!-- For Working with JSon Web Tokens ( JWT) -->
      	<dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
      	</dependency>
```
# yml파일에 spring datasource 설정
```
```

# CORS 에러
- pom에서 spring security 의존성 추가하자마자 CORS 오류 발생
	```
	spring 공식문서  
	Spring Framework provides first class support for CORS. CORS must be processed before Spring Security because the pre-flight request will not contain any cookies (i.e. the JSESSIONID). If the request does not contain any cookies and Spring Security is first, the request will determine the user is not authenticated (since there are no cookies in the request) and reject it.
	스프링 프레임워크는 CORS에대한 일급?(first class)지원을 제공한다. pre-flight request(예비요청)가 어떠한 쿠키에도 포함되지 않기때문에 CORS는 스프링시큐리티 이전에 처리 되어야한다 만약 요청에 어떠한 쿠키가 포함되어 있지않고 스프링시큐리티가 제일 첫번째라면 그 요청에 사용자가 인증되지 않았음을 확인할것이고 그것을 거부할것이다.
	```
- pre-flight request : OPTIONS 메서드를 통해 다른 도메인의 리소스로 HTTP 요청을 보내 실제 요청이 전송하기에 안전한지 확인하는 요청 (corss site 요청으로 유저의 데이터에 영향을 줄 수 있기 때문)
	* 기본적으로 브라우저는 cross-origin 요청을 전송하기 전에 OPTIONS 메소드로 preflight를 전송한다.
이때 Response로 Access-Control-Allow-Origin과 Access-Control-Allow-Methods가 넘어오는데 이는 서버에서 어떤 origin과 어떤 method를 허용하는지 브라우저에게 알려주는 역할을 한다.
브라우저가 결과를 성공적으로 확인하고 나면 cross-origin 요청을 보내서 그 이후 과정을 진행한다.
	
	
	
# Spring Security에서 CORS설정
스프링과 스프링 시큐리티를 함께 사용중이라면 CORS설정은 두 가지 방법으로 할 수 있다.
1. 스프링에서 WebConfigurerAdapter를 상속하는 클래스에 addCorsMappings메소드를 재정의
2. 스프링 시큐리티에서 CorsConfigurationSource 클래스를 만들고 내부에 CorsConfiguration을 세팅한다.
둘 중 하나를 하더라도 스프링 시큐리티를 사용중이라면 WebSecurityConfigurerAdapter를 상속하는 클래스에서 configure를 재정의하여 cors()를 사용해야한다.

1번과 같이 선언하였다면 스프링 시큐리티에서는 스프링에 선언된 CORS구성을 활용하기 때문에 따로 CORS관련 필터를 정의할 필요가 없다.