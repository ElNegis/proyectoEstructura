package Metodos;

import java.util.Date;

public class Metodos_ArbolBin
{
    public static class Nodo {
        String ID;
        String Descripcion;
        String Concentracion;
        int Stock;
        float Costo;
        float Precio;
        String RegistroSanitario;
        Date Fecha;
        String Estado;
        String Presentacion;
        String Laboratorio;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(String ID, String Descripcion, String Concentracion, int Stock, float Costo, float Precio, String RegistroSanitario, Date Fecha, String Estado, String Presentacion, String Laboratorio) {
            this.ID = ID;
            this.Descripcion = Descripcion;
            this.Concentracion = Concentracion;
            this.Stock = Stock;
            this.Costo = Costo;
            this.Precio = Precio;
            this.RegistroSanitario = RegistroSanitario;
            this.Fecha = Fecha;
            this.Estado = Estado;
            this.Presentacion = Presentacion;
            this.Laboratorio = Laboratorio;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public static class ArbolBinario {
        private Nodo raiz;

        public ArbolBinario() {
            this.raiz = null;
        }

        // Método para insertar un nodo
        public void insertarNodo(String ID, String Descripcion, String Concentracion, int Stock, float Costo, float Precio, String RegistroSanitario, Date Fecha, String Estado, String Presentacion, String Laboratorio) {
            Nodo nuevoNodo = new Nodo(ID, Descripcion, Concentracion, Stock, Costo, Precio, RegistroSanitario, Fecha, Estado, Presentacion, Laboratorio);
            if (raiz == null) {
                raiz = nuevoNodo;
            } else {
                Nodo actual = raiz;
                Nodo padre;
                while (true) {
                    padre = actual;
                    if (ID.compareTo(actual.ID) < 0) {
                        actual = actual.izquierdo;
                        if (actual == null) {
                            padre.izquierdo = nuevoNodo;
                            return;
                        }
                    } else {
                        actual = actual.derecho;
                        if (actual == null) {
                            padre.derecho = nuevoNodo;
                            return;
                        }
                    }
                }
            }
        }
        public Nodo buscarNodo(String ID) {
            Nodo actual = raiz;
            while (actual != null) {
                if (actual.ID.equals(ID)) {
                    return actual;
                } else if (ID.compareTo(actual.ID) < 0) {
                    actual = actual.izquierdo;
                } else {
                    actual = actual.derecho;
                }
            }
            return null;  // Devuelve null si el nodo no hay
        }
    }
}
