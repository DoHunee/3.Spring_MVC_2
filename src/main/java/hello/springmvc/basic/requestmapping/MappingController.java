package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * 기본 요청 둘다 허용 /hello-basic, /hello-basic/ HTTP 메서드 모두 허용 GET, HEAD, POST,
   * PUT, PATCH, DELETE
   * http://localhost:8080/hello-basic
   */
  @RequestMapping("/hello-basic")
  public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    

  /**
   * HTTP 메서드 매핑
   * method 특정 HTTP 메서드 요청만 허용
   * GET, HEAD, POST, PUT, PATCH, DELETE
   * http://localhost:8080/mapping-get-v1
   */
  @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
  public String mappingGetV1() {
  log.info("mappingGetV1");
  return "ok";
  }

  /**
   * HTTP 메서드 매핑 축약
   * 편리한 축약 애노테이션 (코드보기)
   * @GetMapping
   * @PostMapping
   * @PutMapping
   * @DeleteMapping
   * @PatchMapping
   * http://localhost:8080/mapping-get-v2
   */
  @GetMapping(value = "/mapping-get-v2")
  public String mappingGetV2() {
  log.info("mapping-get-v2");
  return "ok";
  }


  /**
 * PathVariable (경로 변수) 사용
 * 변수명이 같으면 생략 가능
 * @PathVariable("userId") String userId -> @PathVariable String userId
 * http://localhost:8080//mapping/{userId}
 * http://localhost:8080/mapping/userA
 */
  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable("userId") String data) {
  log.info("mappingPath userId={}", data);
  return "ok";
  }
    
  /**
   * PathVariable (경로 변수) 사용 다중
   * http://localhost:8080//mapping/users/{userId}/orders/{orderId}
   * http://localhost:8080//mapping/users/userA/orders/100
   */
  @GetMapping("/mapping/users/{userId}/orders/{orderId}")
  public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
  log.info("mappingPath userId={}, orderId={}", userId, orderId);
  return "ok";
  }

  /**
   * 파라미터로 추가 매핑
   * params="mode",
   * params="!mode"
   * params="mode=debug"
   * params="mode!=debug" (! = )
   * params = {"mode=debug","data=good"}
   * http://localhost:8080/mapping-param?mode=debug
   */
  @GetMapping(value = "/mapping-param", params = "mode=debug")
  public String mappingParam() {
 log.info("mappingParam");
 return "ok";
}

  /**
   * 특정 헤더로 추가 매핑
   * headers="mode",
   * headers="!mode"
   * headers="mode=debug"
   * headers="mode!=debug" (! = )
   * http://localhost:8080/mapping-header
   * 포스트맨에서 헤더에 mode:debug 입력 후 send 버튼 클릭하면 OK 출력
   */
  @GetMapping(value = "/mapping-header", headers = "mode=debug")
  public String mappingHeader() {
  log.info("mappingHeader");
  return "ok";
  }

  /**
   * Content-Type 헤더 기반 추가 매핑 Media Type
   * consumes="application/json"
   * consumes="!application/json"
   * consumes="application/*"
   * consumes="*\/*"
   * MediaType.APPLICATION_JSON_VALUE
   * http://localhost:8080/mapping-consume
   * 포스트맨에서 헤더에 Content-Type: application/json 입력 후 send 버튼 클릭하면 OK 출력
   */
  @PostMapping(value = "/mapping-consume", consumes = "application/json")
  public String mappingConsumes() {
  log.info("mappingConsumes");
  return "ok";
  }


    /**
   * Accept 헤더 기반 Media Type
   * produces = "text/html"
   * produces = "!text/html"
   * produces = "text/*"
   * produces = "*\/*"
   * http://localhost:8080/mapping-produce
   * 포스트맨에서 헤더에 Accept: text/html 입력 후 send 버튼 클릭하면 OK 출력
   */
  @PostMapping(value = "/mapping-produce", produces = "text/html")public String mappingProduces() {
    log.info("mappingProduces");
    return "ok";
  }
}
