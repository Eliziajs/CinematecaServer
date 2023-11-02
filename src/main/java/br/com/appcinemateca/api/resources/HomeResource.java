package br.com.appcinemateca.api.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/index")
public class HomeResource {

    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Home/index");
      // mv.addObject("ator", new AtorDTO());
        return mv;
    }
}
