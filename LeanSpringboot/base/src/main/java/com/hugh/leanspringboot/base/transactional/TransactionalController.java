package com.hugh.leanspringboot.base.transactional;

import com.hugh.leanspringboot.base.transactional.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactional")
public class TransactionalController {

    @Autowired
    private TransactionalService transactionalService;

    @GetMapping("/test")
    public String test(String name) {
        String res= null;
        try {
            res = transactionalService.save(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
