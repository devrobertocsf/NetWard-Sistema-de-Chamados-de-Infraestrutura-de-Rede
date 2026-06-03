package entidades;

import java.time.LocalDateTime;

import entidade.enums.StatusChamado;

public class Chamado {
private Integer id;
private String equipamento;
private String descricaoDeFeito;
private StatusChamado Status; 
private LocalDateTime dataAbertura; 
private LocalDateTime dataFechamento;
private Tecnico tecnicoResponsavel;







public Chamado(Integer id, String equipamento, String descricaoDeFeito) {
	
	this.id = id;
	this.equipamento = equipamento;
	this.descricaoDeFeito = descricaoDeFeito;
	Status = StatusChamado.ABERTO;
	this.dataAbertura = LocalDateTime.now();
	this.dataFechamento = null;
	this.tecnicoResponsavel = null;
}

//Método toString para podermos monitorar o chamado no console
@Override
public String toString() {
    return "Chamado ID: " + id 
            + "\nEquipamento: " + equipamento 
            + "\nDefeito: " + descricaoDeFeito 
            + "\nStatus: " + Status 
            + "\nAberto em: " + dataAbertura 
            + "\nFechado em: " + (dataFechamento == null ? "Ainda aberto" : dataFechamento)
            + "\nTécnico Responsável: " + (tecnicoResponsavel == null ? "Nenhum" : tecnicoResponsavel.getNome()) 
            + "\n-----------------------------------";
}

//MÉTODO 1: Atribuir Técnico
public void atribuirTecnico(Tecnico tecnico) {
	this.Status = StatusChamado.EM_ATENDIMENTO; 
	this.tecnicoResponsavel = tecnico;
}

//MÉTODO 2: Resolver Chamado
public void resolverChamado() {
	this.Status = StatusChamado.RESOLVIDO;
	this.dataFechamento = LocalDateTime.now();
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEquipamento() {
	return equipamento;
}
public void setEquipamento(String equipamento) {
	this.equipamento = equipamento;
}
public String getDescricaoDeFeito() {
	return descricaoDeFeito;
}
public void setDescricaoDeFeito(String descricaoDeFeito) {
	this.descricaoDeFeito = descricaoDeFeito;
}
public StatusChamado getStatus() {
	return Status;
}
public void setStatus(StatusChamado status) {
	Status = status;
}
public LocalDateTime getDataAbertura() {
	return dataAbertura;
}
public void setDataAbertura(LocalDateTime dataAbertura) {
	this.dataAbertura = dataAbertura;
}
public LocalDateTime getDataFechamento() {
	return dataFechamento;
}
public void setDataFechamento(LocalDateTime dataFechamento) {
	this.dataFechamento = dataFechamento;
}
public Tecnico getTecnicoResponsavel() {
	return tecnicoResponsavel;
}


	
}
