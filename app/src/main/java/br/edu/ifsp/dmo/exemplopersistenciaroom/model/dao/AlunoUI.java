package br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao;


public class AlunoUI {

    private int prontuario;
    private String nome;
    private String curso;

    //construtor, gets e sets.
    @Override
    public String toString() {
        return "AlunoUI{" +
                "prontuario=" + prontuario +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public int getProntuario() {
        return prontuario;
    }

    public void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
