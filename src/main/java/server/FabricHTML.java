package server;

import models.Fabric;
import models.FabricStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/*
Using FabricHTML and FabricAPI as separation of concerns for better structuring and reading of the codebase
 */

@Controller
@RequestMapping("/fabric")
public class FabricHTML {
    //List the entire fabric stash
    @GetMapping
    public String allFabric (Model model) {
        Collection<Fabric> fabrics = FabricStorage.fabrics.values();
        List<Fabric> list = new ArrayList<>(fabrics);

        model.addAttribute("fabrics", fabrics);
        return "allFabric";
    }

}

/*
@Controller
@RequestMapping("/mountains")
public class MountainHTML {
    // list all mountains page
    @GetMapping
    public String showAllMountains(Model model) {
        Collection<Mountain> mountains = MountainStorage.mountains.values();
        List<Mountain> list = new ArrayList<>(mountains);

        model.addAttribute("mountains", mountains);
        return "all_mountains";
    }
    */