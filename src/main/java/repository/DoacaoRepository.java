package repository;

import Enums.*;
import model.Doacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/Doacao";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    List<Doacao> doacoes = new ArrayList<>();

    public DoacaoRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(Doacao doacao) {
        doacoes.add(doacao);
    }

    public void adicionarDoacao(Doacao doacao) {
        String sql = "INSERT INTO doacoes (tipo, descricao, quantidade, unidade_medida, validade, genero, tamanho, centro_distribuicao_id, id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doacao.getTipo().name());
            pstmt.setString(2, doacao.getDescricao());
            pstmt.setInt(3, doacao.getQuantidade());
            if (doacao.getUnidadeMedida() != null) {
                pstmt.setString(4, doacao.getUnidadeMedida().name());
            } else {
                pstmt.setNull(4, Types.VARCHAR);
            }
            if (doacao.getValidade() != null) {
                pstmt.setDate(5, Date.valueOf(doacao.getValidade()));
            } else {
                pstmt.setNull(5, Types.DATE);
            }
            if (doacao.getGenero() != null) {
                pstmt.setString(6, doacao.getGenero().name());
            } else {
                pstmt.setNull(6, Types.VARCHAR);
            }
            if (doacao.getTamanho() != null) {
                pstmt.setString(7, doacao.getTamanho().name());
            } else {
                pstmt.setNull(7, Types.VARCHAR);
            }
            pstmt.setInt(8, doacao.getCentroDistribuicaoId());
            pstmt.setInt(9, doacao.getIdDoacao());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doacao> listarDoacoes() {
        String sql = "SELECT * FROM doacoes";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setIdDoacao(rs.getInt("id"));
                doacao.setTipo(Tipo.valueOf(rs.getString("tipo")));
                doacao.setDescricao(rs.getString("descricao"));
                doacao.setQuantidade(rs.getInt("quantidade"));
                if (rs.getString("unidade_medida") != null) {
                    doacao.setUnidadeMedida(UnidadeMedida.valueOf(rs.getString("unidade_medida")));
                }
                if (rs.getDate("validade") != null) {
                    doacao.setValidade(String.valueOf(rs.getDate("validade").toLocalDate()));
                }
                if (rs.getString("genero") != null) {
                    doacao.setGenero(Genero.valueOf(rs.getString("genero")));
                }
                if (rs.getString("tamanho") != null) {
                    doacao.setTamanho(Tamanho.valueOf(rs.getString("tamanho")));
                }
                doacao.setCentroDistribuicaoId(rs.getInt("centro_distribuicao_id"));
                doacao.setIdDoacao(rs.getInt("id"));
                doacoes.add(doacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doacoes;
    }

    public void deletarDoacao(int idDoacao) {
        String sql = "DELETE FROM doacoes WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDoacao);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
