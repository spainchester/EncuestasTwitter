import javax.swing.JTextArea;
import java.util.Random;

public class BaseDeDatos implements Runnable{

    String datosEncuesta[];
    JTextArea Si, No;

    public BaseDeDatos(String dato[], JTextArea areaSi, JTextArea areNo){
        datosEncuesta = dato;
        Si = areaSi;
        No = areNo;
    }

    private int generarValoresAleatorios() {
        int valorMaximo=1;
        int valorMinimo=0;
        Random r=new Random();
        return valorMinimo+(valorMaximo-valorMinimo)*r.nextInt();


    }

    public void obtenerDatos() {

        int num = 0;
        for (int i = 0; i < datosEncuesta.length; i++) {
            num = (int) (Math.random()*2 + 0);
            if (num == 0) {
                datosEncuesta[i] = "SI";
            }
            else {
                datosEncuesta[i] = "NO";
            }
        }
    }

    public void ordenarDatos(){

        for (int i = 0; i < datosEncuesta.length ; i++) {
            if (datosEncuesta[i] == "SI") {
                Si.setText(Si.getText()+datosEncuesta[i]+", ");

            }
            else {
                No.setText(No.getText()+datosEncuesta[i]+", ");

            }
        }
    }

    @Override
    public void run() {
        obtenerDatos();
        ordenarDatos();
    }

}
