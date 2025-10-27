package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public class LIGOFF implements Ejecutable{

    private Boolean luzApagada;

    public LIGOFF(Boolean luzApagada) {
        this.luzApagada = luzApagada;
    }

    @Override
    public void execute(Robot robot) {
        luzApagada = Boolean.TRUE;
        robot.disminuirBateria(this.consumoBateria());
    }

    @Override
    public Double consumoBateria() {
        if (luzApagada) {
            return 1.0;
        } else {
            return 5.0;
        }
    }

    @Override
    public Integer duracionTarea(Robot robot) {
        if (luzApagada) {
            return 25;
        } else {
            return 90;
        }
    }

}
