package ar.unrn.tp3.bd;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RegistroDeParticipantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcParticipantes implements RegistroDeParticipantes {
    private String url;
    private String user;
    private String password;
    private Connection dbConn;

    private void setupBaseDeDatos() throws SQLException {
        this.url = "jdbc:derby://localhost:1527/participantes";
        this.user = "app";
        this.password = "app";
        try{
            this.dbConn = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
           throw new RuntimeException("error al conectarse con la base de datos");
        }
    }

    @Override
    public void registrarParticipante(Participante participante) throws RuntimeException {
        try {
            setupBaseDeDatos();
            PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");

            st.setString(1, participante.obtenerNombre());
            st.setString(2, participante.obtenerTelefono());
            st.setString(3, participante.obtenerRegion());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar Participante");
        }catch (RuntimeException e1){
            throw e1;
        }
    }
}
