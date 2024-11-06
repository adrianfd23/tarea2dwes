package control;

import dao.PlantaDAO;
import daoimpl.PlantaDAOImpl;
import modelo.Planta;

public class ViveroController {
    private static ViveroController instance;
    private PlantaDAO plantaDAO;

    private ViveroController() {
        plantaDAO = new PlantaDAOImpl();
    }

    public static ViveroController getInstance() {
        if (instance == null) {
            instance = new ViveroController();
        }
        return instance;
    }

    public void registrarNuevaPlanta(String codigo, String nombreComun, String nombreCientifico) {
        Planta planta = new Planta(codigo, nombreComun, nombreCientifico);
        plantaDAO.insertarPlanta(planta);
    }

    public Planta verPlanta(String codigo) {
        return plantaDAO.obtenerPlantaPorCodigo(codigo);
    }

    public void mostrarTodasLasPlantas() {
        plantaDAO.obtenerTodasLasPlantas().forEach(planta -> 
            System.out.println(planta.getCodigo() + " - " + planta.getNombreComun()));
    }
}
