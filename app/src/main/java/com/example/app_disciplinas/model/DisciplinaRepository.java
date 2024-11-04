package com.example.app_disciplinas.model;

import android.content.Context;

import com.example.app_disciplinas.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisciplinaRepository {

    public static List<Disciplina> getDisciplinas(Context context){
        String[]itens = context.getResources().getStringArray(R.array.arrayDisciplinas);
        List<Disciplina> disciplinas = new ArrayList<>();

        for (String disciplinaString: itens) {
            String [] atributos= disciplinaString.split(";");

            int periodo = Integer.parseInt(atributos[0].substring(1,2));
            String nome = atributos[1];
            int img = getDrawableId(atributos[2]);

            disciplinas.add(new Disciplina(nome,periodo,img));
        }
        return disciplinas;
    }

    //para retornar a imagem conforme estabelecido no
    private static int getDrawableId(String drawableName) {
        switch (drawableName) {
            case "assustado":
                return R.drawable.assustado;
            case "pensamento":
                return R.drawable.pensamento;
            case "cansado":
                return R.drawable.cansado;
            default:
                return R.drawable.smile;
        }
    }

    public static List<Disciplina> getDisciplinasPeriodo(int periodo, Context context){
        List<Disciplina> disciplinasPerido = getDisciplinas(context);
        return disciplinasPerido.stream()
                .filter(d -> d.getPeriodo() == periodo)
                .collect(Collectors.toList());
    }

}
