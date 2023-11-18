package model;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class ContatoClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;
    private String tipoContato;
    private Boolean isFavorito;

    private String telefone;
    private String celular;
    private String fax;

    private String observacao;

    private String nomeEmpresa;
    private String cargoEmpresa;

    public ContatoClass(int codigo, String nome, String tipoContato, Boolean isFavorito, String telefone, String celular, String fax, String observacao, String nomeEmpresa, String cargoEmpresa) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoContato = tipoContato;
        this.isFavorito = isFavorito;
        this.telefone = telefone;
        this.celular = celular;
        this.fax = fax;
        this.observacao = observacao;
        this.nomeEmpresa = nomeEmpresa;
        this.cargoEmpresa = cargoEmpresa;
    }

    public ContatoClass() {
    }

    public String[] toArray() {
        String[] array = new String[10];

        array[0] = nome;
        array[1] = tipoContato;
        array[2] = String.valueOf(isFavorito);
        array[3] = Integer.toString(codigo);
        array[4] = telefone;
        array[5] = celular;
        array[6] = fax;
        array[7] = observacao;
        array[8] = nomeEmpresa;
        array[9] = cargoEmpresa;

        return array;

    }

    public ContatoClass arrayTo(String[] array) {
        nome = array[0];
        tipoContato = array[1];
        isFavorito = Boolean.parseBoolean(array[2]);
        codigo = Integer.parseInt(array[3]);
        telefone = array[4];
        celular = array[5];
        fax = array[6];
        observacao = array[7];
        nomeEmpresa = array[8];
        cargoEmpresa = array[9];

        return this;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Boolean getIsFavorito() {
        return isFavorito;
    }

    public void setIsFavorito(Boolean isFavorito) {
        this.isFavorito = isFavorito;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }

}
