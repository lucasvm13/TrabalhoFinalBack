package br.unisul.web.sexta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private int n1;

	private int n2;

	private int n3;

	String status;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ALUNO_DISCIPLINA", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	public Aluno() {

	}

	
	public Aluno(Integer id, String nome, int n1, int n2, int n3, String status) {
		this.id = id;
		this.nome = nome;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.status = status;
	}
	
	public String atualizaStatus (Aluno a) {
		
		double media = 0;
		
		double n1 = a.getN1();
		double n2 = a.getN2();
		double n3 = a.getN3();
		
		media = ((n1+n2+n3)/3);
		
		if(media>=7) {
			return "Aprovado!";
		} 
		if(media<2) {
			return "Reprovado!";
		} 
		
		if((media==2) | (media<7) ) {
			return "Recuperação!";
		}
		return null;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getN3() {
		return n3;
	}

	public void setN3(int n3) {
		this.n3 = n3;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + n1;
		result = prime * result + n2;
		result = prime * result + n3;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (n1 != other.n1)
			return false;
		if (n2 != other.n2)
			return false;
		if (n3 != other.n3)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
