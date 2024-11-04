package com.example.app_disciplinas.ui.disciplinas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_disciplinas.databinding.FragmentDisciplinasBinding;
import com.example.app_disciplinas.model.Disciplina;
import com.example.app_disciplinas.model.DisciplinaRepository;

import java.util.ArrayList;
import java.util.List;

public class DisciplinasFragment extends Fragment {

    private FragmentDisciplinasBinding binding;
    private DisciplinaAdapter disciplinaAdapter;
    private DisciplinasViewModel periodo1ViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        periodo1ViewModel = new ViewModelProvider(this).get(DisciplinasViewModel.class);

        int periodo = 1;
        if (getArguments() != null) {
            periodo = getArguments().getInt("periodo", 1);
        }

        binding = FragmentDisciplinasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerViewDisciplinas;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        disciplinaAdapter = new DisciplinaAdapter(new ArrayList<>());
        recyclerView.setAdapter(disciplinaAdapter);


        List<Disciplina> disciplinasDoPrimeiroPeriodo = DisciplinaRepository.getDisciplinasPeriodo(periodo, requireContext());
        periodo1ViewModel.setDisciplinas(disciplinasDoPrimeiroPeriodo);


        periodo1ViewModel.getDisciplinas().observe(getViewLifecycleOwner(), disciplinas -> {
            disciplinaAdapter.setDisciplinaList(disciplinas);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
