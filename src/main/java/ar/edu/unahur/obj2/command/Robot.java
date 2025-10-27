package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Ejecutable;

public class Robot {
    private Double nivelBateria = 100.0;
    private List<Ejecutable> registroTareas = new ArrayList<>();

    public Robot(Double nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public void realizarTarea(Ejecutable tarea) {
        try {
            tarea.execute(this);
            registroTareas.add(tarea);
        } catch (Exception e) {
            System.out.println("El robot no tiene bateria suficiente para realizar la tarea");
        }
    }

    public Double getNivelBateria() {
        return nivelBateria;
    }

    public Integer tiempoDeTareasAEjecutarPosible() {
        return (int) (nivelBateria * 80);
    }

    public Double promedioTareasEjecutadas() {
        return registroTareas.stream().mapToInt(t -> t.duracionTarea(this)).average().orElse(0);
    }

    public void aumentarBateria(Double nivel) {
        this.nivelBateria += nivel;
    }

    public void disminuirBateria(Double nivel) {
       this.nivelBateria = Math.max(0, nivelBateria - nivel);
    }
}
