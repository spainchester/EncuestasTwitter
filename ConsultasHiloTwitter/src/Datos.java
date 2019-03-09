import javax.swing.JProgressBar;

public class Datos implements Runnable{

    String datos[];
    JProgressBar porcientoSi, porcientoNo;

    public Datos(String arreglo[], JProgressBar barSi, JProgressBar barNo) {
        datos = arreglo;
        porcientoSi = barSi;
        porcientoNo = barNo;
    }

    public void cargarEncuestas(){
        int SIs=0;
        int NOs=0;
        porcientoSi.setValue(5000000);
        porcientoNo.setValue(5000000);
        for (int i = 0; i <datos.length ; i++) {
            if (datos[i] == "SI") {
                SIs++;
            }
            else {
                NOs++;
            }
        }
        porcientoSi.setValue(SIs);
        porcientoNo.setValue(NOs);
    }

    @Override
    public void run() {
        cargarEncuestas();
    }
}
