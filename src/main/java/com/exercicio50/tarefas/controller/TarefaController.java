package com.exercicio50.tarefas.controller;

import com.exercicio50.tarefas.model.Tarefa;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefas;
    }

    @PostMapping
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefa;
    }
}
