package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // LogTestController.class() 같음 Slf4j

    @GetMapping("/log-test")
    public String logTest(){
        String name = "String";

        // 패키지와 그 하위 로그 레벨 설정을 하여 볼 수 있음
        log.trace("trace log={}",name); // {} 가 없다면 연산이 이루어짐
        log.debug("debug log={}",name);

        // 운영서버는 info로 설정
        log.warn("warn log={}",name);
        log.error("error log={}",name);
        log.info(" info log ={}",name);

        return "ok";
    }
}
