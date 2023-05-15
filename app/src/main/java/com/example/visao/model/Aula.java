package com.example.visao.model;

public class Aula {
    private int id;
    private String dias;
    private String horas;
    private String cidade;
    private String estado;
    private String cep;
    private String curso;
    private String resumo;
    private int codProfessor;

    public Aula(int id, String dias, String horas, String cidade, String estado, String cep, String curso, String resumo, int codProfessor) {
        this.id = id;
        this.dias = dias;
        this.horas = horas;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.curso = curso;
        this.resumo = resumo;
        this.codProfessor = codProfessor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", dias='" + dias + '\'' +
                ", horas='" + horas + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", curso='" + curso + '\'' +
                ", resumo='" + resumo + '\'' +
                '}';
    }
}
