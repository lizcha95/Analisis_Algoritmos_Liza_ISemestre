public class AG {

    public static void main(String[] args) {
    int [] hora_inicio =   {7,9,9,7,10,15,17,20,5,13,14,18,19,15,16,12,14,19,21,22,3,5,2,7,8,4,2,9,7,6};
    String [] actividades  =   {"Actividad_0","Actividad_1","Actividad_2","Actividad_3","Actividad_4",
                                 "Actividad_5","Actividad_6","Actividad_7","Actividad_8","Actividad_9",
                                 "Actividad_10","Actividad_11","Actividad_12","Actividad_13","Actividad_14"};
    int [] hora_final    =   {9,10,11,9,13,17,18,23,7,15,17,20,20,16,18,15,16,20,22,23,3,2,7,6,5,4,9,8,10,12};

        Poblacion poblacion = new Poblacion(40, true);
        FuncionDeFitness.establecerSolucion("11111111111111111111");
        FuncionDeFitness.establecerActividades(actividades, hora_inicio, hora_final);
        
        // Evolve our Poblacion until we reach an optimum solution
        int contadorDeGeneraciones = 0;
        while (poblacion.obtenerFittest().obtenerFitness() < FuncionDeFitness.obtenerMaxFitness() && contadorDeGeneraciones < 15) {
            contadorDeGeneraciones++;
            System.out.println("Horario: " + contadorDeGeneraciones + " Mejor Actividad: " + poblacion.obtenerFittest().obtenerFitness());
            poblacion = Algoritmo.evolucionarPoblacion(poblacion);
        }
        System.out.println("La solución encontrada es la siguiente:");
        System.out.println("Horario Número: " + contadorDeGeneraciones);
        System.out.println("Horario final de la Actividad:");
        Individuo respuesta = poblacion.obtenerFittest();
        System.out.println(respuesta);
        System.out.println();

    }
}
