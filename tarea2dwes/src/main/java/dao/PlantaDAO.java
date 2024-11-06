package dao;

import java.util.List;
import modelo.Planta;

public interface PlantaDAO {
    void insertarPlanta(Planta planta);
    Planta obtenerPlantaPorCodigo(String codigo);
    List<Planta> obtenerTodasLasPlantas();
    void actualizarPlanta(Planta planta);
    void eliminarPlanta(String codigo);
}
