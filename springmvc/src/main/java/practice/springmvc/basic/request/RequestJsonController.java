package practice.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.springmvc.basic.HelloData;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * {"username": "hello", "age":20}
 * content-type : application/json
 * */
@Slf4j
@Controller
public class RequestJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);
        HelloData data = objectMapper.readValue(messageBody,HelloData.class);
        log.info("username={}, age={}",data.getUsername(), data.getAge());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws JsonProcessingException {
        HelloData data = objectMapper.readValue(messageBody,HelloData.class);
        log.info("username={}, age={}",data.getUsername(), data.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData data)  {
        /* 직접 만든 객체를 지정 가능
        * @RequestBody는 생략 불가능
        * 생략하면 @ModelAttribute가 붙어버리기 때문..
        * */

        log.info("username={}, age={}",data.getUsername(), data.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> httpEntity)  {
        // 직접 만든 객체를 지정 가능
        HelloData data = httpEntity.getBody();
        log.info("username={}, age={}",data.getUsername(), data.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData data)  {
        // 직접 만든 객체를 지정 가능
        log.info("username={}, age={}",data.getUsername(), data.getAge());
        return data;
    }



}
