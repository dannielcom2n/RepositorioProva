package src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.model;

import java.util.List;

import src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.dao.MedicamentoDao;
import src.br.senai.sc.tii20141n1.pw4.daniel.cadastroDeMedicamento.model.dominio.Medicamento;

public class MedicamentoRN {
	
	private MedicamentoDao dao;
	
	public MedicamentoRN(){
		dao = new MedicamentoDao();
	}
	
	public void Salvar(Medicamento medicamento) throws Exception{
		if (medicamento.getNome().trim().isEmpty()) {
			throw new Exception("O nome é obrigatorio");
			
		}
		dao.Salvar(medicamento);
		
	}
	public List<Medicamento> listar(){
		return dao.listarTodos();
	}
	
	public Medicamento buscarPorId(Integer id){
		return dao.buscarPorid(id);
	}
	public void Excluir(Integer id)throws Exception{
		dao.Excluir(id);
	}

}
