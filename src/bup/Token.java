/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bup;

/**
 *
 * @author bruni
 */
public class Token {
    final TipoToken tipo;
    final String lexema;

    final int posicion;

    public Token(TipoToken tipo, String lexema, int posicion) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.posicion = posicion;
    }

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.posicion = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Token)) {
            return false;
        }

        if(this.tipo == ((Token)o).tipo){
            return true;
        }

        return false;
    }

    public String toString(){
        return tipo + " " + lexema + " ";
    }
}
