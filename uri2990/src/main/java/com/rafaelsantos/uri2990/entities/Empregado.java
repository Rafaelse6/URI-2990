package com.rafaelsantos.uri2990.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empregados")
public class Empregado {
	
	@Id
	private String cpf;
	private String enome;
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name = "cpf_supervisor")
	private Empregado supervisor;
	
	@OneToMany(mappedBy = "supervisor")
	private List<Empregado> supervisionados;
	
	@ManyToOne
	@JoinColumn(name = "dnumero")
	private Departamento departamento;
	
	@ManyToMany
	@JoinTable(name = "trabalha",
		joinColumns = @JoinColumn(name = "cpf_emp"),
		inverseJoinColumns = @JoinColumn(name = "pnumero"))
	private Set<Projeto> projetosOndeTrabalha = new HashSet<>();
	
	public Empregado() {}

	public Empregado(String cpf, String enome, Double salary, Empregado supervisor, Departamento departamento) {
		super();
		this.cpf = cpf;
		this.enome = enome;
		this.salary = salary;
		this.supervisor = supervisor;
		this.departamento = departamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEnome() {
		return enome;
	}

	public void setEnome(String enome) {
		this.enome = enome;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Empregado getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Empregado supervisor) {
		this.supervisor = supervisor;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Empregado> getSupervisionados() {
		return supervisionados;
	}

	public Set<Projeto> getProjetosOndeTrabalha() {
		return projetosOndeTrabalha;
	}
}
