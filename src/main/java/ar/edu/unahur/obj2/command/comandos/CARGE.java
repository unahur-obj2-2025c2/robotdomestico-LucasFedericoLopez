package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public class CARGE implements Ejecutable{
    private Double minutosDeCarga;

    public CARGE(Double minutosDeCarga) {
        this.minutosDeCarga = minutosDeCarga;
    }

    @Override
    public void execute(Robot robot) {
        Double carga = minutosDeCarga * 0.8;
        Double restante = carga - robot.getNivelBateria();
        Double cargaReal = Math.min(restante, carga);
        robot.aumentarBateria(cargaReal);
    }

    @Override
    public Double consumoBateria() {
        return 0.0;
    }

    @Override
    public Integer duracionTarea(Robot robot) {
        double carga = minutosDeCarga * 0.8;
        double restante = 100 - robot.getNivelBateria();
        double cargaReal = Math.min(carga, restante);
        return (int) ((cargaReal / 0.8) * 60);
    }

}
