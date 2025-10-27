package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public class CLEAN implements Ejecutable{
    private Boolean estaLimpio;
    private Integer metrosCuadrados;

    public CLEAN(Boolean estaLimpio,Integer metrosCuadrados) {
        this.estaLimpio = estaLimpio;
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public void execute(Robot robot) {
        estaLimpio = Boolean.TRUE;
        robot.disminuirBateria(this.consumoBateria());
    }

    @Override
    public Double consumoBateria() {
        return 5.0 * metrosCuadrados;
    }

    @Override
    public Integer duracionTarea(Robot robot) {
        return 180 * metrosCuadrados;
    }

    //get para que no mande advertencia, no es necesario.
    public Boolean getEstaLimpio() {
        return estaLimpio;
    }
}
