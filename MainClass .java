public class MainClass {

    public static void main(String[] args) {

        caso1_ConectividadCiudades();
        System.out.println();

        caso2_RedSocial();
        System.out.println();

        caso3_RutasDeEnvio();
    }

    // =========================================================
    // CASO 1: Grafo NO dirigido SIN etiquetas
    // Mapa de conectividad entre ciudades (Listas de adyacencia)
    // =========================================================
    private static void caso1_ConectividadCiudades() {

        Nodo<String> cali = new Nodo<>(0, "Cali");
        Nodo<String> medellin = new Nodo<>(1, "Medellin");
        Nodo<String> pereira = new Nodo<>(2, "Pereira");
        Nodo<String> ibague = new Nodo<>(3, "Ibague");
        Nodo<String> bogota = new Nodo<>(4, "Bogota");
        Nodo<String> popayan = new Nodo<>(5, "Popayan");

        // dirigido = false, ponderado = false
        Grafo_LA<String> grafo = new Grafo_LA<>(false, false);

        grafo.agregarNodo(cali);
        grafo.agregarNodo(medellin);
        grafo.agregarNodo(pereira);
        grafo.agregarNodo(ibague);
        grafo.agregarNodo(bogota);
        grafo.agregarNodo(popayan);

        // Aristas sin etiqueta
        grafo.agregarArista(cali, medellin);
        grafo.agregarArista(cali, pereira);
        grafo.agregarArista(cali, ibague);
        grafo.agregarArista(cali, bogota);
        grafo.agregarArista(cali, popayan);
        grafo.agregarArista(medellin, bogota);

        System.out.println("CASO 1: Conectividad entre ciudades");
        grafo.mostrarGrafo();
    }

    // =========================================================
    // CASO 2: Grafo dirigido SIN etiquetas
    // Red social: "u sigue a v" (Listas de adyacencia)
    // =========================================================
    private static void caso2_RedSocial() {

        Nodo<String> diego = new Nodo<>(0, "Diego");
        Nodo<String> kevin = new Nodo<>(1, "Kevin");
        Nodo<String> daniela = new Nodo<>(2, "Daniela");
        Nodo<String> katherine = new Nodo<>(3, "Katherine");

        // dirigido = true, ponderado = false
        Grafo_LA<String> grafo = new Grafo_LA<>(true, false);

        grafo.agregarNodo(diego);
        grafo.agregarNodo(kevin);
        grafo.agregarNodo(daniela);
        grafo.agregarNodo(katherine);

        // Arcos: el primero sigue al segundo
        grafo.agregarArista(diego, kevin);
        grafo.agregarArista(kevin, diego);
        grafo.agregarArista(diego, daniela);
        grafo.agregarArista(daniela, diego);
        grafo.agregarArista(diego, katherine);

        System.out.println("CASO 2: Red social (quien sigue a quien)");
        grafo.mostrarGrafo();
    }

    // =========================================================
    // CASO 3: Grafo dirigido CON etiquetas
    // Rutas de envio y costos en COP (Matriz de adyacencia)
    // =========================================================
    private static void caso3_RutasDeEnvio() {

        Nodo<String> cali = new Nodo<>(0, "Cali");
        Nodo<String> medellin = new Nodo<>(1, "Medellin");
        Nodo<String> pereira = new Nodo<>(2, "Pereira");
        Nodo<String> ibague = new Nodo<>(3, "Ibague");
        Nodo<String> bogota = new Nodo<>(4, "Bogota");
        Nodo<String> popayan = new Nodo<>(5, "Popayan");

        // dirigido = true
        Grafo_MA<String> grafo = new Grafo_MA<>(true);

        grafo.agregarNodo(cali);
        grafo.agregarNodo(medellin);
        grafo.agregarNodo(pereira);
        grafo.agregarNodo(ibague);
        grafo.agregarNodo(bogota);
        grafo.agregarNodo(popayan);

        // Arcos con costo de envio (origen, destino, costo)
        grafo.agregarArista(cali, medellin, 7000);
        grafo.agregarArista(cali, pereira, 8000);
        grafo.agregarArista(cali, ibague, 12000);
        grafo.agregarArista(cali, popayan, 8000);
        grafo.agregarArista(bogota, cali, 5000);
        grafo.agregarArista(bogota, medellin, 7000);
        grafo.agregarArista(ibague, pereira, 8000);

        System.out.println("CASO 3: Rutas de envio y costos (COP)");
        grafo.mostrarGrafo();

        // Consultas de ejemplo
        System.out.println("Costo Cali -> Medellin: "
            + grafo.obtenerPeso(cali, medellin));
        System.out.println("Costo Medellin -> Cali: "
            + grafo.obtenerPeso(medellin, cali) + " (INF = no hay ruta)");
    }
}
