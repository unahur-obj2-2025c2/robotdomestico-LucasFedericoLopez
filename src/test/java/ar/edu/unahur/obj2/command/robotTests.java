package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.CARGE;
import ar.edu.unahur.obj2.command.comandos.CLEAN;
import ar.edu.unahur.obj2.command.comandos.Ejecutable;
import ar.edu.unahur.obj2.command.comandos.LIGOFF;
import ar.edu.unahur.obj2.command.comandos.LIGON;

public class robotTests {
    Robot chappie = new Robot(100.0);
    Robot giganteAcero = new Robot(0.0);

    @Test
    void dadoUnRobotDescargadoSeCargaAl100Porciento() {
        Ejecutable cargarAlMaximo = new CARGE(125.0);
        giganteAcero.realizarTarea(cargarAlMaximo);
        assertEquals(100.0, giganteAcero.getNivelBateria());
    }

    @Test
    void dadoUnRobotConCargaCompleta_QueRealiza3TareasElPromedioDeTareaEsDe316() {
        Ejecutable limpiarCuarto = new CLEAN(Boolean.TRUE, 5);
        Ejecutable apagarLuz = new LIGOFF(Boolean.FALSE);
        Ejecutable prenderLuz = new LIGON(Boolean.FALSE);
        chappie.realizarTarea(limpiarCuarto);
        chappie.realizarTarea(apagarLuz);
        chappie.realizarTarea(prenderLuz);
        assertEquals((limpiarCuarto.duracionTarea(chappie) + apagarLuz.duracionTarea(chappie)+ 
        prenderLuz.duracionTarea(chappie)) / 3.0, chappie.promedioTareasEjecutadas());
    }

    @Test
    void dadoUnRobotConAlgunasTareasCompletadas_SuTiempoDeTareasAEjecutarPosibleDisminuye() {
        Ejecutable limpiarCuarto = new CLEAN(Boolean.TRUE, 5);
        Ejecutable apagarLuz = new LIGOFF(Boolean.FALSE);
        Ejecutable prenderLuz = new LIGON(Boolean.FALSE);
        chappie.realizarTarea(limpiarCuarto);
        chappie.realizarTarea(apagarLuz);
        chappie.realizarTarea(prenderLuz);
        assertEquals(5840 , chappie.tiempoDeTareasAEjecutarPosible());
    }

}
