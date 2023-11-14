package br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Curso;

@Dao
public interface CursoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insereCurso(Curso... cursos);

    @Delete
    void removeCurso(Curso curso);

    @Update
    void alteraCurso(Curso curso);

    @Query("SELECT * FROM tb_cursos")
    List<Curso> recuperaTodos();

    @Query("SELECT * FROM tb_cursos WHERE codigo = :codigoCurso LIMIT 1")
    Curso recuperaCurso(int codigoCurso);

}
