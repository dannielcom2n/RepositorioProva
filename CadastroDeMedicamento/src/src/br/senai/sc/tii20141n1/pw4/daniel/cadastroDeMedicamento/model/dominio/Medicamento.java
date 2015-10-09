package src.br.senai.sc.tii20141n1.pw4.daniel.cadastroDeMedicamento.model.dominio;

public class Medicamento {
	private long id;
	private String nome;
	private Integer dosagem;
	private String intervalo;
	private Integer duracao;

	public Medicamento() {

	}

	public Medicamento(long id, String nome, Integer dosagem, String intervalo,
			Integer duracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dosagem = dosagem;
		this.intervalo = intervalo;
		this.duracao = duracao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDosagem() {
		return dosagem;
	}

	public void setDosagem(Integer dosagem) {
		this.dosagem = dosagem;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

}
