package src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.br.senai.sc.tii20141n1.pw4.daniel.cadastroDeMedicamento.model.dominio.Medicamento;

public class MedicamentoDao extends Dao {

	private final String INSERT = "INSERT INTO medicamento(nome, dosagem,intervalo,duracao) values(?,?,?,?)";
	private final String UPDATE = "UPDATE medicamento set nome = ?, dosagem = ?,intervalo = ?,duracao = ? WHERE id = ? ";
	private final String DELETE = "DELETE from medicamento WHERE id = ?";
	private final String SELECT = "SELECT * from medicamento";
	private final String SELECT_ID = "SELECT * from medicamento WHERE id = ?";

	public void Salvar(Medicamento medicamento) {
		try {
			PreparedStatement ps = null;
			ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, medicamento.getNome());
			ps.setInt(2, medicamento.getDosagem());
			ps.setString(3, medicamento.getIntervalo());
			ps.setInt(4, medicamento.getDuracao());
			

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao conectar o  insert " + e);
			e.printStackTrace();
		}

	}

	public void Alterar(Medicamento medicamento) {
		try {
			PreparedStatement ps = null;
			ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, medicamento.getNome());
			ps.setInt(2, medicamento.getDosagem());
			ps.setString(3, medicamento.getIntervalo());
			ps.setInt(4, medicamento.getDuracao());
			ps.setLong(5, medicamento.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao executar o Update" + e);
			e.printStackTrace();
		} finally {
			getConnection();
		}

	}

	public void Excluir(Integer id) {
		try {
			PreparedStatement ps = null;
			getConnection();
			ps = getConnection().prepareStatement(DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao executar o delete" + e);
			e.printStackTrace();
		} finally {
			getConnection();
		}

	}

	public List<Medicamento> listarTodos() {
		List<Medicamento> md = new ArrayList<Medicamento>();
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			getConnection();
			ps = getConnection().prepareStatement(SELECT);
			rs = ps.executeQuery();
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("Nome"));
				medicamento.setDosagem(rs.getInt("Dosagem"));
				medicamento.setIntervalo(rs.getString("Intervalo"));
				medicamento.setDuracao(rs.getInt("Duracao"));
				medicamento.setId(rs.getInt("Id"));
				md.add(medicamento);

			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o select aquiii " + e);

		} finally {
			getConnection();
		}
		return md;

	}

	public Medicamento buscarPorid(Integer id) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("Nome"));
				medicamento.setDosagem(rs.getInt("Dosagem"));
				medicamento.setIntervalo(rs.getString("Intervalo"));
				medicamento.setDuracao(rs.getInt("Duração"));
				medicamento.setId(rs.getInt("id"));
				return medicamento;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao executar o select_id de user" + e);
			e.printStackTrace();
		}
		return null;
	}

}
