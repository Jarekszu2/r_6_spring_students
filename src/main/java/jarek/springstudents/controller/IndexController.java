package jarek.springstudents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/") // warto dodać drugi / (wtedy jak zapomnimy ponięj się nie wywala; wymuszamy tak dodatkową ścieżkę demo
public class IndexController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String wyswietlMojaStroneHelloWorldTySpringu() {
        return "strona-Hallo";
    }

    @GetMapping(path = "/hallo")
    public String wyswietlHallo() {
        return "strona-Hallo";
    }

    @GetMapping(path = "/halloTo") // /halloTo?imie=Jarek (required=false - brak parametru nie wywala strony)
    public String wyswietlHalloTo(Model model,
                                  @RequestParam(name = "imie", required = false) String parametrImie) {
        model.addAttribute("atrybutImie", parametrImie);
        return "strona-Hallo-To";
    }

    @GetMapping(path = "/halloMyBaby/{babyName}") // halloMyBaby/Jarek
    public String wyswietlHalloToBaby(Model model,
                                      @PathVariable(name = "babyName") String variable) {
        model.addAttribute("atrybutImie", variable);
        return "strona-Hallo-To";
    }
}
