package com.juran.chatting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@Slf4j
public class ChatController {

    @GetMapping("/")
    public String home() {
        return "main";
    }

//    @GetMapping("/chat")
//    public String chat() {
//        return "chat";
//    }

    @GetMapping("/chat")
    public String chat(@RequestParam(name = "id") String id, Model model) {
        log.info("id: " + id);
        model.addAttribute("id", id);
        return "chat";
    }

    @PostMapping("/chat")
    public void chatPost(@RequestBody Map<String, Object> body, HttpServletResponse response) {
        String id = body.get("id").toString();
    }
}