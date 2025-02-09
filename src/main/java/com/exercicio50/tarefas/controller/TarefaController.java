package com.exercicio50.tarefas.controller;

import com.exercicio50.tarefas.model.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller // Indica que esta classe é um controlador Spring
public class TarefaController {
    //Apresenta em memória a lista armazenada das tarefas
    private final List<Tarefa> tarefaList = new ArrayList<>();

    // Exibir o formulário
    @GetMapping("/tarefas")
    public String formTarefas(Model model) {
        // Adiciona um objeto "Tarefa" vazio para o formulário
        model.addAttribute("tarefa", new Tarefa());
        return "tarefas"; // Retorna o template do thymeleaf "tarefas.html"
    }

    // Processar o formulário de registo
    @PostMapping("/tarefas/add") //Mapeia o url "/tarefas/add" para o metodo em questão quando o formulário é submetido
    public String addTarefas(@ModelAttribute Tarefa tarefa, Model model) {
        // Adicionar uma tarefa à lista
        tarefaList.add(tarefa);

        // Aqui vai surgir a confirmação do add
        System.out.println("Tarefa registada: ID: " + tarefa.getId() + "Titulo: " + tarefa.getTitulo());

        // Redireciona a página "GetMapping" para a lista users (não é o HTML)
        return "redirect:/tarefas/lista_tarefas";
    }

    // Lista Tarefas
    @GetMapping("tarefas/lista_tarefas")
    public String mostrarListaTarefas(Model model) {
        // Adicionar a lista de tarefas ao modelo
        model.addAttribute("tarefas", tarefaList);
        return "lista_tarefas"; //nome do ficheiro html
    }
}