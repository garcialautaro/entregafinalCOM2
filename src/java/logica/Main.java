package logica;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ControladoraLogica control = new ControladoraLogica();
        
        control.altaCliente("Garcia", "2634540527", "Nahuel Huapi 2306",
                "37622822", "garcialautaro2013@gmail.com", new Date(), 
                "Argentino", "Lautaro"); 
        
    }

}