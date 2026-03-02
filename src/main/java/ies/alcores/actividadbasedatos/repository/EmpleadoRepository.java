package ies.alcores.actividadbasedatos.repository;

import ies.alcores.actividadbasedatos.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    // Esta anotación @Query es la que permite que el Service encuentre el método
    @Query("SELECT e FROM Empleado e WHERE e.departamento_id = ?1")
    List<Empleado> buscarPorDepartamento(long depto_id);
}