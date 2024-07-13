package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CsvImporter {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Doacao";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    public void importCsv(String csvFilePath) {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Doacao", "root", "12345678")) {

            String query = "INSERT INTO tabela_doacao (descricao, genero, tamanho, tipo, quantidade, unidade_medida) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                preparedStatement.setString(1, data[0]); // Descrição
                preparedStatement.setString(2, data[1]); // Gênero
                preparedStatement.setString(3, data[2]); // Tamanho
                preparedStatement.setString(4, data[3]); // Tipo
                preparedStatement.setInt(5, Integer.parseInt(data[4])); // Quantidade
                preparedStatement.setString(6, data[5]); // Unidade de Medida

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
