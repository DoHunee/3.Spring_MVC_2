package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
// http://localhost:8080/log-test
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring"; // 로그 메시지에 사용할 변수

        // 로그 레벨별로 로그 메시지를 출력
        log.trace("trace log={}", name);  // 가장 낮은 로그 레벨, 상세한 디버그 정보
        log.debug("debug log={}", name);  // 디버그 레벨, 디버그에 유용한 정보
        
        log.info(" info log={}", name);  // 정보 레벨, 일반적인 정보 메시지
        log.warn(" warn log={}", name);  // 경고 레벨, 잠재적인 문제 경고
        log.error("error log={}", name);  // 에러 레벨, 오류 발생 시 출력
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);
        
        return "ok";
    }
}
