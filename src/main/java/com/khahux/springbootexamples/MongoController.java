package com.khahux.springbootexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MongoController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final UserRepository userRepository;

    @Autowired
    public MongoController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/mongo")
    public String mongo(Model model) {
        User user = new User("ma1", "ming1", "195022586@qq.com");
        userRepository.save(user);

        return "redirect:/";
    }
}
