package ies.alcores.actividadbasedatos.service;

import ies.alcores.actividadbasedatos.model.Empleado;
import ies.alcores.actividadbasedatos.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    // CONSULTA 1: Todos
    public List<Empleado> obtenerTodos() {
        return repository.findAll();
    }

    // CONSULTA 2: Por ID
    public Empleado obtenerPorId(long id) {
        return repository.findById(id).orElse(null);
    }

    // CONSULTA 3: Por Departamento (Aquí usamos el nuevo nombre del Repository)
    public List<Empleado> obtenerPorDepto(long depto_id) {
        // Llamamos al método que creamos con la @Query manual
        return repository.buscarPorDepartamento(depto_id);
    }

    // INSERT
    public Empleado guardar(Empleado e) {
        return repository.save(e);
    }

    // DELETE
    public void eliminar(long id) {
        repository.deleteById(id);
    }
}