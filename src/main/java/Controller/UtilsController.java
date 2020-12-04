package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SiletFlower
 * @date 2020/11/17 15:08:00
 * @description
 */
@Controller
@RequestMapping("/utils")
public class UtilsController {

    @RequestMapping("goHome")
    public String goHome(){
        return "index";
    }

}
