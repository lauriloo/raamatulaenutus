package ee.meriloo.laenutus.controller;

import ee.meriloo.laenutus.model.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ee/meriloo/laenutus")
public class RestController {


    @RequestMapping(path = "nimekiri", method = RequestMethod.GET)
    public @ResponseBody String getNimekiri() {
        return "nimekiri";
    }

    @RequestMapping(path = "list", method = RequestMethod.GET)
    public @ResponseBody
    Catalog getList() {
        return new Catalog();
    }
}
