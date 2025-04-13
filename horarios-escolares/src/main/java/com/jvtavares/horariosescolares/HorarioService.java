package com.jvtavares.horariosescolares;

import com.jvtavares.horariosescolares.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HorarioService {

    private Map<String, Map<String, String>> horariosGerados = new LinkedHashMap<>();

    public Map<String, Map<String, String>> gerarHorarios(List<Professor> professores, List<Turma> turmas) {
        Map<String, Map<String, String>> horarios = new LinkedHashMap<>();

        List<String> dias = Arrays.asList("Segunda", "Terca", "Quarta", "Quinta", "Sexta");
        List<String> horariosDia = Arrays.asList(
                "08:00", "09:00", "10:00", "11:00",
                "13:00", "14:00", "15:00", "16:00", "17:00");

        System.out.println("📚 Lista de turmas:");
        for (Turma turma : turmas) {
            System.out.println("   - Turma: " + turma.getNome() + ", Número de aulas: " + turma.getNumeroDeAulas());
        }
        for (Turma turma : turmas) {
            Map<String, String> horarioTurma = new LinkedHashMap<>();
            int aulasRestantes = turma.getNumeroDeAulas();

            System.out.println("⏳ Gerando horários para a turma: " + turma.getNome());

            outer: for (String dia : dias) {
                for (String hora : horariosDia) {
                    if (aulasRestantes == 0)
                        break outer;

                    String slot = dia + "-" + hora;
                    System.out.println("⏰ Slot atual: " + slot);

                    List<Professor> candidatos = new ArrayList<>();

                    for (Professor p : professores) {
                        System.out.println("🔍 Verificando professor: " + p.getNome());
                        if (p.getMaxAulas() > 0 && p.getDisponibilidade().contains(slot)) {
                            candidatos.add(p);
                            System.out.println("✔️ Professor disponível: " + p.getNome() + " para " + slot);
                        }
                    }

                    if (candidatos.isEmpty()) {
                        System.out.println("❌ Nenhum professor disponível para: " + slot);
                        continue;
                    }

                    // Seleciona o primeiro candidato (você pode melhorar essa lógica)
                    Professor escolhido = candidatos.get(0);
                    horarioTurma.put(slot, escolhido.getNome());
                    escolhido.setMaxAulas(escolhido.getMaxAulas() - 1);
                    aulasRestantes--;

                    System.out.println("✅ Atribuído: " + escolhido.getNome() + " para " + slot);
                }
            }
            System.out.println("✅ Horário gerado para a turma: " + turma.getNome());

            horarios.put(turma.getNome(), horarioTurma);
            horariosGerados = horarios;
        }

        return horariosGerados;
    }

    public Map<String, Map<String, String>> getHorariosGerados() {
        return horariosGerados;
    }
}