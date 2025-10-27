package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public class INFO implements Ejecutable{

    @Override
    public void execute(Robot robot) {
        System.out.println("El promedio de tiempo de las tareas ejecutadas es de: " + robot.promedioTareasEjecutadas() + " Segundos");
    }

    @Override
    public Double consumoBateria() {
        return 0.0;
    }

    @Override
    public Integer duracionTarea(Robot robot) {
        return 0;
    }

}
