package com.example.app_disciplinas.ui.disciplinas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app_disciplinas.model.Disciplina;

import java.util.List;

public class DisciplinasViewModel extends ViewModel {

    private final MutableLiveData<List<Disciplina>> disciplinas;

    public DisciplinasViewModel() {
        disciplinas = new MutableLiveData<>();
    }

    public void setDisciplinas(List<Disciplina> listaDisciplinas) {
        disciplinas.setValue(listaDisciplinas);
    }

    public LiveData<List<Disciplina>> getDisciplinas() {
        return disciplinas;
    }
}
