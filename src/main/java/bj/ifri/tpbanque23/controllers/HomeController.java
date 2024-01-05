package bj.ifri.tpbanque23.controllers;

import bj.ifri.tpbanque23.entities.Agence;
import bj.ifri.tpbanque23.entities.Client;
import bj.ifri.tpbanque23.repositories.AgenceRepository;
import bj.ifri.tpbanque23.repositories.ClientRepository;
import bj.ifri.tpbanque23.repositories.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private AgenceRepository agenceRepo;

    @Autowired
    private CompteBancaireRepository compteRepo;

    @RequestMapping(value = "/nouveau", method = RequestMethod.GET)
    public String newClient(Model model) {

        List<Agence> agences = agenceRepo.findAll();

        model.addAttribute("agences", agences);

        model.addAttribute("client", new Client());

        return "addclient";
    }


    @PostMapping("/enregistrer")
    public String saveClient(@ModelAttribute("client") Client client) {

        if (client.getAgence() != null && client.getAgence().getId() != null) {
            client.setAgence(agenceRepo.findById(client.getAgence().getId()).get());
        }
        clientRepo.save(client);
        return "redirect:/nouveau";
    }
    @RequestMapping(value = "/clientsagence")
    public String allAgency(Model model) {

        model.addAttribute("listAgency", agenceRepo.findAll());
        model.addAttribute("client", new Client());
        return "agencyclients";
    }
    @RequestMapping(value = "/clientsdecouvert", method = RequestMethod.GET)
    public String clientsDecouvert(Model model) {


        return "overdrawnclients";
    }

}
