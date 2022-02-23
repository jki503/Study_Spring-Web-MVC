package practice.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // body에 그냥 그 데이터를 반환함
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("trace log={}", name); // local 서버에서
        log.debug("debug log={}", name); // 개발 서버에서
        log.info("info log={}", name); // 운영 서버에서도 봐야할 중요한 정보
        log.warn("warn log={}", name); // 경고
        log.error("error log={}", name); // 에러

        return "ok";
    }

}
