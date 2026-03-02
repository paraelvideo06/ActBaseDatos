package ies.alcores.actividadbasedatos.controller;

import ies.alcores.actividadbasedatos.model.Empleado;
import ies.alcores.actividadbasedatos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    // --- 3 CONSULTAS (GET) ---

    // 1. Obtener todos
    @GetMapping
    public List<Empleado> getAll() {
        return service.obtenerTodos();
    }

    // 2. Obtener uno por ID
    @GetMapping("/buscar/{id}")
    public Empleado getById(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // 3. Consulta filtrada: Empleados por Departamento
    @GetMapping("/depto/{deptoId}")
    public List<Empleado> getByDepto(@PathVariable Long deptoId) {
        return service.obtenerPorDepto(deptoId);
    }

    // --- 1 INSERT (POST) ---
    @PostMapping("/guardar")
    public Empleado create(@RequestBody Empleado empleado) {
        return service.guardar(empleado);
    }

    // --- 1 DELETE (DELETE) ---
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.eliminar(id);
        return "Empleado eliminado correctamente con ID: " + id;
    }
}