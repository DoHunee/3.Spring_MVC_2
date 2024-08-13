package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // http://localhost:8080/response-view-v1
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        // ModelAndView 객체를 생성하여 반환
        // 뷰 이름을 "response/hello"로 설정하고, 데이터 "hello!"를 추가
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    // http://localhost:8080/response-view-v2
    public String responseViewV2(Model model) {
        // 모델에 데이터 "hello!!"를 추가
        // 뷰 이름을 "response/hello"로 반환
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    // http://localhost:8080/response/hello
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        // 모델에 데이터 "hello!!"를 추가
        // 반환 타입이 void이므로 요청 URL에 해당하는 뷰 이름("response/hello")이 자동으로 사용됨
        model.addAttribute("data", "hello!!");
    }
}
