package server;

import com.google.gson.Gson;
import models.Vape;
import models.VapesStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/vapes")

public class VapeAPI {

    @PostMapping
    @ResponseBody
    public ModelAndView createVape(
            @RequestParam("brand") String brand,
            @RequestParam("model") String model,
            @RequestParam("wattage") int wattage
    ) {
        Vape vape = new Vape(brand, model, wattage);
        VapesStorage.vapes.put(vape.id, vape);
        return new ModelAndView("forward:/vapes");

    }

    @GetMapping
    @ResponseBody
    public List<Vape> getAllVapes(){
        Collection<Vape> vapes = VapesStorage.vapes.values();
        return new ArrayList<>(vapes);

    }

    @PutMapping("/{id}")
    @ResponseBody
    public Vape updatedVapes(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Vape newVape = gson.fromJson(body, Vape.class);

        Vape vape = VapesStorage.vapes.get(id);
        vape.brand = newVape.brand;
        vape.model = newVape.model;
        vape.wattage = newVape.wattage;
        return vape;

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Vape deleteVape(@PathVariable("id") int id){
        Vape vape = VapesStorage.vapes.get(id);
        VapesStorage.vapes.remove(id);
        return vape;
    }

}
