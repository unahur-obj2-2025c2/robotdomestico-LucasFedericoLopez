package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Robot;

public interface Ejecutable {
    void execute (Robot robot);
    Double consumoBateria();
    Integer duracionTarea(Robot robot);
}
