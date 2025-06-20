package org.cibertec.solucionT2.controller;

import org.cibertec.solucionT2.entity.PeliculaEntity;
import org.cibertec.solucionT2.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/mantenimiento")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new PeliculaEntity());
        model.addAttribute("listaPeliculas", peliculaService.getAll());
        return "mantenimientoPelicula";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("pelicula") PeliculaEntity pelicula) {
        if (pelicula.getIdPelicula() != null) {
            peliculaService.modify(pelicula);
        } else {
            peliculaService.create(pelicula);
        }
        return "redirect:/pelicula/mantenimiento";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pelicula", peliculaService.getById(id));
        model.addAttribute("listaPeliculas", peliculaService.getAll());
        return "mantenimientoPelicula";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        peliculaService.remove(id);
        return "redirect:/pelicula/mantenimiento";
    }
}
