# jwt (with spring security)

## 인증 방식

- 토큰 기반 인증
로그인을 시도했을 때 서버에서 가입된 사용자인지 확인 후에 이미 가입된 사용자일 경우 사용자에게 토큰을 발급한다. 발급받은 토큰은 클라이언트측에서 관리하고 로그인이 필요한 서비스를 이용할 때 토큰을 함께 보내어 인증을 시도한다.

- 세션 기반 인증의 문제점
세션 기반 인증을 사용하면 클라이언트의 인증을 서버에 저장 한다. 대부분 메모리에 저장하게 되는데 로그인한 사용자가 증가했을 때는 과부하가 발생한다. 이를 해결하기 위해 데이터베이스에 저장하기도 하지만 마찬가지로 사용자가 증가했을 때 성능이 저하될 수 있다.

- 토큰 기반 인증의 장점(세션 기반 인증의 문제점을 해결)  
	1. 토큰 기반 인증은 서버와 클라이언트가 지속해서 연결을 유지하지 않는다.(stateless)
	=> 세션 기반 인증에서 연결을 유지하기 위해 저장해야 했던 사용자의 정보를 저장하지 않아도 되기 때문에 메모리의 사용을 줄일 수 있다.  
	
	2. 세션 기반 인증의 경우 처음에 접속했던 서버와 세션이 생성되어 해당 서버에만 요청을 보낼 수 있다. 
	=> 토큰 사용시 어떠한 서버로 요청을 해도 상관이 없다.(서버는 클라이언트의 토큰을 통해 인증을 하기 때문) 
	=> 서버의 확장이 용이

	3. 토큰 기반 인증은 유효한 토큰을 포함해서 서버에 요청하면 되기 때문에 여러 디바이스와 호환이 가능하며 다른 도메인에서도 요청이 정상적으로 처리된다.

# 구현

## 의존성 추가  
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
## yml파일에 spring datasource 설정
```
```

## CORS 에러
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
	
	
	
## Spring Security에서 CORS설정
스프링과 스프링 시큐리티를 함께 사용중이라면 CORS설정은 두 가지 방법으로 할 수 있다.
1. 스프링에서 WebConfigurerAdapter를 상속하는 클래스에 addCorsMappings메소드를 재정의
2. 스프링 시큐리티에서 CorsConfigurationSource 클래스를 만들고 내부에 CorsConfiguration을 세팅한다.
둘 중 하나를 하더라도 스프링 시큐리티를 사용중이라면 WebSecurityConfigurerAdapter를 상속하는 클래스에서 configure를 재정의하여 cors()를 사용해야한다.

1번과 같이 선언하였다면 스프링 시큐리티에서는 스프링에 선언된 CORS구성을 활용하기 때문에 따로 CORS관련 필터를 정의할 필요가 없다.
