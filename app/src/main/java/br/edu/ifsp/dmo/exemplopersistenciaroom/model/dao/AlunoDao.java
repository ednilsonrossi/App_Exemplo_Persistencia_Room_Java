package br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Aluno;

@Dao
public interface AlunoDao {

    @Insert
    void create(Aluno aluno);

    @Query("SELECT * FROM tb_alunos ORDER BY nome_aluno")
    List<Aluno> recuperateAll();

    @Query("SELECT A.prontuario, A.nome_aluno AS nome, C.nome AS curso " +
            "FROM tb_alunos AS A " +
            "INNER JOIN tb_cursos AS C " +
            "ON A.id_curso = C.codigo" )
    List<AlunoUI> recuperateAlunoUI();

    @Update
    void update(Aluno aluno);

    @Delete
    void delete(Aluno aluno);
}
