public class FuncionDeFitness {
    // Se declaran las listas que definen las horas de comienzo, finalización y actividades, y sus tamaños
    static int [] hora_comienzo = new int[30];
    static String [] actividadesFijas = new String  [15] ;
    static int [] hora_final = new int[20];
    
    static byte[] solucion = new byte[30];

    // Función que asigna los parámetros a las listas antes declaradas
    public static void establecerActividades(String [] pActividades, int [] pHora_comienzo, int[] pHora_final) {
        hora_comienzo = pHora_comienzo;
        hora_final = pHora_final; 
        actividadesFijas = pActividades;  
    }

    public static void establecerSolucion(byte[] nuevaSolucion) {
        solucion = nuevaSolucion;
    }
    
    static void establecerSolucion(String nuevaSolucion) {
        solucion = new byte[nuevaSolucion.length()];
        for (int i = 0; i < nuevaSolucion.length(); i++) {
            String caracter = nuevaSolucion.substring(i, i + 1);
            if (caracter.contains("0") || caracter.contains("1")) {
                solucion[i] = Byte.parseByte(caracter);
            } else {
                solucion[i] = 0;
            }
        }
    }
    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int obtenerFitness(Individuo individuo) {
        Integer [] horas = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        
        int fitness = 0;
        for (int i = 0; i < individuo.tamanno() && i < solucion.length; i++) {
            if (individuo.obtenerGen(i) == solucion[i]) {
                fitness++;
                for(int hora_inicial = hora_comienzo[i]; hora_inicial < hora_final[i]; hora_inicial++ ) {
                    if(horas[hora_inicial] != null) {
                        horas[hora_inicial] = null;
                    }
                    else {
                        fitness = 0;
                    }
                }
            }
        }
        return fitness;
    }
    // Obtener el fitness optimo
    static int obtenerMaxFitness(){
        int maxFitness = solucion.length;
        return maxFitness;
    }
}