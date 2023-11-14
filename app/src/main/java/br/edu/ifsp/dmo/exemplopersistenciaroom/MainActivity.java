package br.edu.ifsp.dmo.exemplopersistenciaroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;
import java.util.Random;

import br.edu.ifsp.dmo.exemplopersistenciaroom.database.AppDatabase;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Aluno;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.Curso;
import br.edu.ifsp.dmo.exemplopersistenciaroom.model.dao.AlunoUI;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                AppDatabase.DATABASE_NAME)
                .build();
        //novosCursos();
        listaCursos();
        listaAlunos();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    database
                            .getAlunoDao()
                            .create(
                                    new Aluno("Chaves", new Random().nextInt(3)+1)
                            );
                    listaAlunos();
                }
            }).start();
        });
    }

    private void novosCursos(){
        Curso c1 = new Curso("Análise e Desenvolvimento de Sistemas");
        Curso c2 = new Curso("Sistemas para Internet");
        Curso c3 = new Curso("Técnico em Informática");

        new Thread(new Runnable() {
            @Override
            public void run() {
                database.getCursoDao().insereCurso(c1, c2, c3);
            }
        }).start();
    }

    private void listaCursos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Curso> cursos = database.getCursoDao().recuperaTodos();
                Log.i("Room", "---- Lista de Cursos ----");
                for(Curso c : cursos) {
                    Log.i("Room", c.getCodigo() + " - " + c.getNome());
                }
                Log.i("Room", "---- Fim da lista de cursos ----");
            }
        }).start();
    }

    private void listaAlunos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<AlunoUI> alunoUIS = database.getAlunoDao().recuperateAlunoUI();
                Log.i("Room", "==== Lista de alunos UI ====");
                for(AlunoUI a : alunoUIS){
                    Log.i("Room", a.toString());
                }
                Log.i("Room", "==== Fim da Lista de alunos UI ====");
            }
        }).start();
    }
}