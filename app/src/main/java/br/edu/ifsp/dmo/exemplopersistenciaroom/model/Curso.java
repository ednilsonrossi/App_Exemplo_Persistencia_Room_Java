package br.edu.ifsp.dmo.exemplopersistenciaroom.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_cursos")
public class Curso {

    @PrimaryKey(autoGenerate = true)
    private int codigo;

    @ColumnInfo(index = true)
    private String nome;

    //Construtores, Getters e Setters

    public Curso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Ignore
    public Curso(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
