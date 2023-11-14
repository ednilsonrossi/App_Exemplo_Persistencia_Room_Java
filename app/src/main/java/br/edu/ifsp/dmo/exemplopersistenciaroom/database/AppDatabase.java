package br.edu.ifsp.dmo.exemplopersistenciaroom.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Aluno;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Curso;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao.AlunoDao;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao.CursoDao;

@Database(entities = {Aluno.class, Curso.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "escola.db";

    public abstract CursoDao getCursoDao();

    public abstract AlunoDao getAlunoDao();
}
