package server;


import com.google.gson.Gson;
import models.Vape;
import models.VapesStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/vapes")

public class VapesHTML {

    @GetMapping
    public String showAllVapes(Model model) {
        Collection<Vape> vapes = VapesStorage.vapes.values();
        List<Vape> list = new ArrayList<>(vapes);

        model.addAttribute("vapes", vapes);
        return "all_vapes";
    }

    @GetMapping("/new")
    public String editVapesForm(
            @PathVariable("id") int id,
            Model model
    ){
        Vape vape = VapesStorage.vapes.get(id);

        model.addAttribute("id", vape.id);
        model.addAttribute("name", vape.brand);
        model.addAttribute("model", vape.model);
        model.addAttribute("wattage", vape.wattage);

        return "edit_vape";
    }
}
