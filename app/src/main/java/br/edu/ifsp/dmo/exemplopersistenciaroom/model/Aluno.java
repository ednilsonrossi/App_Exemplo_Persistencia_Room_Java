package br.edu.ifsp.dmo.exemplopersistenciaroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "tb_alunos",
        foreignKeys = @ForeignKey(entity = Curso.class,
                parentColumns = "codigo",
                childColumns = "id_curso")
)
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    private int prontuario;

    @ColumnInfo(name = "nome_aluno")
    private String nome;

    @ColumnInfo(name = "id_curso")
    private int codigoCurso;

    //Construtor, gets e sets.

    public Aluno(int prontuario, String nome, int codigoCurso) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.codigoCurso = codigoCurso;
    }

    @Ignore
    public Aluno(String nome, int codigoCurso) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
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

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "prontuario=" + prontuario +
                ", nome='" + nome + '\'' +
                ", codigoCurso=" + codigoCurso +
                '}';
    }
}

