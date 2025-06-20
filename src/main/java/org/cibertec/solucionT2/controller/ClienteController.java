package org.cibertec.solucionT2.controller;

import org.cibertec.solucionT2.entity.ClienteEntity;
import org.cibertec.solucionT2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/mantenimiento")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        model.addAttribute("listaClientes", clienteService.getAll());
        return "mantenimientoCliente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente") ClienteEntity cliente) {
        if (cliente.getIdCliente() != null) {
            clienteService.modify(cliente);
        } else {
            clienteService.create(cliente);
        }
        return "redirect:/cliente/mantenimiento";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", clienteService.getById(id));
        model.addAttribute("listaClientes", clienteService.getAll());
        return "mantenimientoCliente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        clienteService.remove(id);
        return "redirect:/cliente/mantenimiento";
    }
}
