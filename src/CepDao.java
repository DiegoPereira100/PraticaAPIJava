import java.sql.*;

public class CepDao {
    public void saveEndereco(Endereco endereco){
        String query = "INSERT INTO enderecosconsultados (cep, rua, bairro, cidade, estado) values (?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = BD.connection();
            System.out.println("Conexão bem sucedida!");
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    public void listEnderecos(){
        String query = "SELECT * FROM enderecosconsultados";
        Connection connection = null;
        try {
            connection = BD.connection();
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                System.out.println("ID: " + rs.getInt("id") +
                        ", CEP: " + rs.getString("cep") +
                        ", Rua: " + rs.getString("rua") +
                        ", Bairro: " + rs.getString("bairro") +
                        ", Cidade: " + rs.getString("cidade") +
                        ", Estado: " + rs.getString("estado") +
                        ", Data/Hora: " + rs.getString("dataHora"));
            }
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
