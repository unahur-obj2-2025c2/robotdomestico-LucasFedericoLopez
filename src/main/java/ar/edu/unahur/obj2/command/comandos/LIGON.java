package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public class LIGON implements Ejecutable{
    private Boolean luzEncendida;

    public LIGON(Boolean luzEncendida) {
        this.luzEncendida = luzEncendida;
    }

    @Override
    public void execute(Robot robot) {
        luzEncendida = Boolean.TRUE;
        robot.disminuirBateria(this.consumoBateria());
    }

    @Override
    public Double consumoBateria() {
        if (luzEncendida) {
            return 1.0;
        } else {
            return 5.0;
        }
    }

    @Override
    public Integer duracionTarea(Robot robot) {
        if (luzEncendida) {
            return 25;
        } else {
            return 90;
        }
    }

}
