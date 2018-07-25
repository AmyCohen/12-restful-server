package server;
import com.google.gson.Gson;


/*
Using FabricHTML and FabricAPI as separation of concerns for better structuring and reading of the codebase
 */

import models.Fabric;
import models.FabricStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("api/fabrics")
public class FabricAPI {

    //CREATE
    @PostMapping
    public ModelAndView createFabric(
        @RequestParam("name") String name,
        @RequestParam("category") String catagory,
        @RequestParam("base") String base,
        @RequestParam("bestStore") String bestStore,
        @RequestParam("isCustom") Boolean isCustom
        ) throws IOException {

        Fabric newFabric = new Fabric(name, catagory, base, bestStore, isCustom);
        FabricStorage.fabrics.put(newFabric.id, newFabric);

        return new ModelAndView("redirect:/fabrics");
//        return sendRedirect("allFabric");
    }

//    private String sendRedirect(String location)
//            throws IOException {
//        return location;
//    }
    /*
    ===== POSSIBLE HELP =====
    @GetMapping("/goToViewPage")
    public ModelAndView passParametersWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("viewPage");
        modelAndView.addObject("message", "Baeldung");
        return modelAndView;
    }
     */



    //READ ALL
    @GetMapping
    @ResponseBody
    public List<Fabric> getAllFabric() {
        Collection<Fabric> allFabric = FabricStorage.fabrics.values();
        return new ArrayList<>(allFabric);
    }

    //READ ONE
    @GetMapping("/{id}")
    @ResponseBody
    public Fabric showOneFabric(@PathVariable("id") int id) {
        Fabric result = FabricStorage.fabrics.get(id);
        return result;
    }

    //UPDATE
    @PutMapping("/{id}")
    @ResponseBody
    public Fabric updateFabricEntry(
        @PathVariable("id") int id,
        @RequestBody String body
    ){
        Gson gson = new Gson();
        Fabric updateFabric = gson.fromJson(body, Fabric.class);

        Fabric fabrics = FabricStorage.fabrics.get(id);
        fabrics.name = updateFabric.name;
        fabrics.category = updateFabric.category;
        fabrics.base = updateFabric.base;
        fabrics.bestStore = updateFabric.bestStore;
        fabrics.isCustom = updateFabric.isCustom;

        return updateFabric;
    }

    //DESTROY
    @DeleteMapping("/{id}")
    @ResponseBody
    public Fabric deleteFabric(@PathVariable("id") int id) {
        Fabric deleteFabric = FabricStorage.fabrics.get(id);
        FabricStorage.fabrics.remove(id);
        return deleteFabric;
    }
}