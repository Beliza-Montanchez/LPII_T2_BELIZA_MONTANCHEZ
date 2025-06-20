package org.cibertec.solucionT2.controller;

import org.cibertec.solucionT2.entity.AlquilerEntity;
import org.cibertec.solucionT2.entity.ClienteEntity;
import org.cibertec.solucionT2.service.AlquilerService;
import org.cibertec.solucionT2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/mantenimiento")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alquiler", new AlquilerEntity());
        model.addAttribute("listaAlquileres", alquilerService.getAll());
        model.addAttribute("listaClientes", clienteService.getAll());
        return "mantenimientoAlquiler";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("alquiler") AlquilerEntity alquiler) {
        // Asignar cliente desde ID
        if (alquiler.getCliente() != null && alquiler.getCliente().getIdCliente() != null) {
            ClienteEntity cliente = clienteService.getById(alquiler.getCliente().getIdCliente());
            alquiler.setCliente(cliente);
        }

        // Validar total mínimo
        if (alquiler.getTotal() == null || alquiler.getTotal() < 1) {
            alquiler.setTotal(1);
        }

        // Guardar o actualizar
        if (alquiler.getIdAlquiler() != null) {
            alquilerService.modify(alquiler);
        } else {
            alquilerService.create(alquiler);
        }

        return "redirect:/alquiler/mantenimiento";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alquiler", alquilerService.getById(id));
        model.addAttribute("listaAlquileres", alquilerService.getAll());
        model.addAttribute("listaClientes", clienteService.getAll());
        return "mantenimientoAlquiler";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        alquilerService.remove(id);
        return "redirect:/alquiler/mantenimiento";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Integer id, Model model) {
        AlquilerEntity alquiler = alquilerService.getById(id);
        model.addAttribute("alquiler", alquiler);
        return "detalleAlquiler";
    }
}
