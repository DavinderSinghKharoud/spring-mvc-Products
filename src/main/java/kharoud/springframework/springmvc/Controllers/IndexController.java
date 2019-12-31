package kharoud.springframework.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
