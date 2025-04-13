package com.jvtavares.horariosescolares.controller;

import com.jvtavares.horariosescolares.model.Horario;
import com.jvtavares.horariosescolares.model.Professor;
import com.jvtavares.horariosescolares.model.Turma;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jvtavares.horariosescolares.repository.ProfessorRepository;
import com.jvtavares.horariosescolares.repository.HorarioRepository;
import com.jvtavares.horariosescolares.repository.TurmaRepository;
import org.springframework.ui.Model;
import com.jvtavares.horariosescolares.HorarioService;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping("/")
public class HorarioController {

    private final ProfessorRepository professorRepo;
    private final HorarioService horarioService;
    private final HorarioRepository horarioRepository;
    private final TurmaRepository turmaRepo;

    public HorarioController(ProfessorRepository professorRepo, HorarioService horarioService,
            HorarioRepository horarioRepository, TurmaRepository turmaRepo) {
        this.professorRepo = professorRepo;
        this.horarioService = horarioService;
        this.horarioRepository = horarioRepository;
        this.turmaRepo = turmaRepo;
    }

    @GetMapping("/professores")
    public String cadastroProfessor() {
        return "professores";
    }

    @PostMapping("/api/professores")
    public String adicionarProfessor(@RequestParam String nome, @RequestParam String materia,
            @RequestParam String disponibilidade, @RequestParam int maxAulas) {
        List<String> disponibilidadeList = List.of(disponibilidade.split(","));
        Professor professor = new Professor(nome, materia, disponibilidadeList, maxAulas);
        professorRepo.save(professor);
        return "redirect:/";
    }

    @GetMapping("/turmas")
    public String turmas() {
        return "turmas";
    }

    @PostMapping("/api/turmas")
    public String salvarTurma(@RequestParam String nome, @RequestParam int numeroDeAulas) {
        turmaRepo.save(new Turma(nome, numeroDeAulas));
        return "redirect:/";
    }

    @GetMapping("/gerar")
    public String gerarHorarios(RedirectAttributes redirectAttributes) {
        System.out.println("🔄 Iniciando a geração de horários...");
        List<Professor> professores = professorRepo.findAll();
        List<Turma> turmas = turmaRepo.findAll();
        horarioService.gerarHorarios(professores, turmas);
        return "redirect:/horarios";
    }

    @GetMapping("/horarios")
    public String exibirHorarios(Model model) {
        model.addAttribute("horarios", horarioService.getHorariosGerados());
        return "horarios"; // ← nome da view (horarios.html)
    }

}
