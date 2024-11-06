package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import control.DatabaseConnection;
import dao.PlantaDAO;
import modelo.Planta;

public class PlantaDAOImpl implements PlantaDAO {
    private Connection connection;

    public PlantaDAOImpl() {
        connection = DatabaseConnection.getConnection();
    }

    public void insertarPlanta(Planta planta) {
        String query = "INSERT INTO Planta (codigo, nombre_comun, nombre_cientifico) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, planta.getCodigo());
            stmt.setString(2, planta.getNombreComun());
            stmt.setString(3, planta.getNombreCientifico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Planta obtenerPlantaPorCodigo(String codigo) {
        Planta planta = null;
        String query = "SELECT * FROM Planta WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                planta = new Planta(rs.getString("codigo"), rs.getString("nombre_comun"), rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planta;
    }

    public List<Planta> obtenerTodasLasPlantas() {
        List<Planta> plantas = new ArrayList<>();
        String query = "SELECT * FROM Planta";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Planta planta = new Planta(rs.getString("codigo"), rs.getString("nombre_comun"), rs.getString("nombre_cientifico"));
                plantas.add(planta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plantas;
    }

    public void actualizarPlanta(Planta planta) {
        String query = "UPDATE Planta SET nombre_comun = ?, nombre_cientifico = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, planta.getNombreComun());
            stmt.setString(2, planta.getNombreCientifico());
            stmt.setString(3, planta.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPlanta(String codigo) {
        String query = "DELETE FROM Planta WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
