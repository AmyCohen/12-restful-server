package server;

import models.Fabric;
import models.FabricStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/*
Using FabricHTML and FabricAPI as separation of concerns for better structuring and reading of the codebase
 */

@Controller
@RequestMapping("/fabrics")
public class FabricHTML {

    //LIST the entire fabric stash
    @GetMapping
    public String allFabric (Model model) {
        Collection<Fabric> fabrics = FabricStorage.fabrics.values();
        List<Fabric> list = new ArrayList<>(fabrics);

        model.addAttribute("fabrics", fabrics);
        return "allFabric";
    }

    //CREATE an HTML form
    @GetMapping("/new")
    public String createNewFabricForm() {
        return "createNewFabric";
    }

    //UPDATE an HTML form
    @GetMapping("/{id}/edit")
    public String editFabricForm(
            @PathVariable("id") int id,
            Model model
    ) {
        Fabric fabricEditing = FabricStorage.fabrics.get(id);

        model.addAttribute("id", fabricEditing.id);
        model.addAttribute("name", fabricEditing.name);
        model.addAttribute("category", fabricEditing.category);
        model.addAttribute("base", fabricEditing.base);
        model.addAttribute("bestStore", fabricEditing.bestStore);
        model.addAttribute("isCustom", fabricEditing.isCustom);

        return "editFabrics";
    }

}

/*

*/