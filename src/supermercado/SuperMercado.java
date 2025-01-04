
package supermercado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import supermercado.Cereales;
import supermercado.Detergente;
import supermercado.EsAlimento;
import supermercado.Vino;

public class SuperMercado {

    
    private static ArrayList<Object> productos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int op;

        System.out.println("**************************");
        System.out.println("    Productos ");
        System.out.println("***************************");
        for (;;) {
            System.out.println("1.- Altas");
            System.out.println("2.- Salir");
            System.out.print("Elegir Opción: ");
            op = lectura.nextInt();
            lectura.nextLine(); // Limpia el buffer

            switch (op) {
                case 1:
                    Menu(lectura);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opción Equivocada. Inténtelo nuevamente.");
                    break;
            }
            if (op == 2) break;
        }

        
        Reporte(productos);
    }

    public static void Menu(Scanner vs) {
        int op1;

        System.out.println("1.- Cereales");
        System.out.println("2.- Detergentes");
        System.out.println("3.- Vinos");
        System.out.println("4.- Reportes");
        System.out.print("Elegir Opción: ");
        op1 = vs.nextInt();
        vs.nextLine();

        switch (op1) {
            case 1:
                Cereales(vs);
                break;
            case 2:
                Detergente(vs);
                break;
            case 3:
                Vinos(vs);
                break;
            case 4:
                Reporte(productos);
                break;
            default:
                System.out.println("Opción equivocada. Inténtelo nuevamente.");
                break;
        }
    }

    public static void Cereales(Scanner vc) {
        System.out.print("Digite la marca: ");
        String marca = vc.nextLine();

        System.out.print("Digite el tipo de cereal: ");
        String tipoCereal = vc.nextLine();

        System.out.print("Digite el precio: ");
        double precio = vc.nextDouble();
        vc.nextLine(); 

        System.out.println("Ingrese la fecha de caducidad:");
        System.out.print("Digite el día: ");
        int dia = vc.nextInt();
        System.out.print("Digite el mes: ");
        int mes = vc.nextInt();
        System.out.print("Digite el año: ");
        int anio = vc.nextInt();
        vc.nextLine(); 

        Cereales cereal = new Cereales(marca, tipoCereal, precio);
        cereal.setCaducidad(LocalDate.of(anio, mes, dia));

        productos.add(cereal);
        System.out.println("Cereal registrado con éxito.");
    }

    public static void Detergente(Scanner vc) {
        System.out.print("Digite la marca: ");
        String marca = vc.nextLine();

        System.out.print("Digite el tipo de envase: ");
        String tipoEnvase = vc.nextLine();

        System.out.print("Digite el precio: ");
        double precio = vc.nextDouble();
        vc.nextLine(); 

        System.out.print("Digite el volumen: ");
        double volumen = vc.nextDouble();
        vc.nextLine(); 
        
        Detergente detergente = new Detergente(marca, precio);
        detergente.setVolumen(volumen);
        detergente.setTipoEnvase(tipoEnvase);

        System.out.print("¿El producto tiene descuento? (true/false): ");
        boolean tieneDescuento = vc.nextBoolean();
        vc.nextLine(); 

        if (tieneDescuento) {
            System.out.print("Digite el porcentaje de descuento: ");
            double descuento = vc.nextDouble();
            vc.nextLine();  
            detergente.setDescuento(descuento);
        }

        productos.add(detergente);
        System.out.println("Detergente registrado con éxito.");
    }

    public static void Vinos(Scanner vc) {
        
    }

    public static void Reporte(ArrayList<Object> lista) {
        int totalCalorias = 0;

        for (Object producto : lista) {
            System.out.println(producto);

            if (producto instanceof EsAlimento) {
                EsAlimento alimento = (EsAlimento) producto;
                totalCalorias += alimento.getCalorias();
            }
        }

        System.out.println("Total de calorías: " + totalCalorias);
    }
}
