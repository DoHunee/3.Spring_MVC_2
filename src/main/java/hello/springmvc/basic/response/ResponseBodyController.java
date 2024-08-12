package hello.springmvc.basic.response;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j  // 로깅을 위한 Lombok 어노테이션으로, 로그를 쉽게 사용할 수 있게 해줍니다.
@Controller  // 이 클래스를 Spring MVC 컨트롤러로 지정합니다. @RestController 대신 사용되며, 이 경우 @ResponseBody를 메서드에 개별적으로 지정해야 합니다.
//@RestController  // 주석 처리된 부분으로, 이 어노테이션을 사용하면 @Controller와 @ResponseBody를 합쳐서 사용할 수 있습니다.
public class ResponseBodyController {

    // 첫 번째 버전: HttpServletResponse를 사용하여 직접 HTTP 응답을 작성하는 방법
    // http://localhost:8080/response-body-string-v1
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");  // HTTP 응답 바디에 "ok" 문자열을 직접 씁니다.
    }

    /**
     * 두 번째 버전: ResponseEntity를 사용하여 응답 데이터와 상태 코드를 함께 반환하는 방법
     * @return ResponseEntity<String> - 응답 바디에 "ok" 문자열과 HTTP 상태 코드 200(OK)을
     * 포함하는 ResponseEntity 객체를 반환합니다.
     * http://localhost:8080/response-body-string-v2
     */
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);  // 응답 바디에 "ok"와 상태 코드 200을 포함한 ResponseEntity를 반환합니다.
    }


    // 세 번째 버전: @ResponseBody를 사용하여 반환값이 응답 바디에 직접 작성되도록 하는 방법
    // http://localhost:8080/response-body-string-v3
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";  // "ok" 문자열이 응답 바디에 직접 작성되며, 상태 코드는 기본적으로 200(OK)입니다.
    }


    // 네 번째 버전: JSON 데이터를 포함하는 ResponseEntity 객체를 반환하는 방법
    // http://localhost:8080/response-body-json-v1
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();  // HelloData 객체를 생성합니다.
        helloData.setUsername("userA");  // username 필드에 "userA"를 설정합니다.
        helloData.setAge(20);  // age 필드에 20을 설정합니다.
        return new ResponseEntity<>(helloData, HttpStatus.OK);  // HelloData 객체와 상태 코드 200을 포함한 ResponseEntity를 반환합니다.
    }


    // 다섯 번째 버전: @ResponseBody와 @ResponseStatus를 사용하여 JSON 데이터를 반환하는 방법
    // http://localhost:8080/response-body-json-v2
    @ResponseStatus(HttpStatus.OK)  // HTTP 상태 코드를 200(OK)으로 설정합니다.
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();  // HelloData 객체를 생성합니다.
        helloData.setUsername("userA");  // username 필드에 "userA"를 설정합니다.
        helloData.setAge(20);  // age 필드에 20을 설정합니다.
        return helloData;  // HelloData 객체가 JSON 형태로 응답 바디에 직접 작성됩니다.
    }
}
