package src.br.senai.sc.tii2014n1.pw4.daniel.cadastroDeMedicamento.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.model.MedicamentoRN;
import src.br.senai.sc.tii20141n1.pw4.daniel.cadastroDeMedicamento.model.dominio.Medicamento;

@ManagedBean
public class MedicamentoMB {

	private List<Medicamento> usuarios;
	private Medicamento medicamento;
	private MedicamentoRN rn;

	@PostConstruct
	public void Init() {
		medicamento = new Medicamento();
		rn = new MedicamentoRN();
	}

	public List<Medicamento> getUsuarios() {

		if (usuarios == null) {
			usuarios = rn.listar();

		}
		return usuarios;
	}

	public void setUsuarios(List<Medicamento> usuarios) {
		this.usuarios = usuarios;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public String Salvar() {
		try {
			rn.Salvar(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "userlist";

	}

	public String Excluir(String idParam) {
		
		Long id = Long.parseLong(idParam);
		try {
			rn.Excluir(id);
			usuarios =  null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public String Editar(String idParam) {
		
		Long id = Long.parseLong(idParam);
		medicamento = rn.buscarPorId(id);
		return "userform";

	}

}
