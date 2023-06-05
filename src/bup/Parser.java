/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bup;

import java.util.List;

/**
 *
 * @author bruni
 */
public class Parser {
    private final List<Token> tokens;

    private final Token identificador = new Token(TipoToken.IDENTIFICADOR, "");
    private final Token select = new Token(TipoToken.SELECT, "select");
    private final Token from = new Token(TipoToken.FROM, "from");
    private final Token distinct = new Token(TipoToken.DISTINCT, "distinct");
    private final Token coma = new Token(TipoToken.COMA, ",");
    private final Token punto = new Token(TipoToken.PUNTO, ".");
    private final Token asterisco = new Token(TipoToken.ASTERISCO, "*");
    private final Token finCadena = new Token(TipoToken.EOF, "");

    private int i = 0;
    //CONTADORES DE LOS STACK
    private short QN = 0
            , DN = 0
            , PN = 0
            , AN = 0
            , A1N = 0
            , A2N = 0
            , A3N = 0
            , TN = 0
            , T1N = 0
            , T2N = 0
            , T3N = 0;
    private boolean hayErrores = false;
    //STACK
    private String[] Q = new String[4];
    private String[] D = new String[2];
    private String[] P = new String[1];
    private String[] A = new String[2];
    private String[] A1 = new String[2];
    private String[] A2 = new String[2];
    private String[] A3 = new String[2];
    private String[] T = new String[2];
    private String[] T1 = new String[2];
    private String[] T2 = new String[2];
    private String[] T3 = new String[1];
    

    private Token preanalisis;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }

    public void parse(){
        i = 0;
        l = 0;
        preanalisis = tokens.get(i);
        if(preanalisis.equals(select)){
            //Q
            coincidir(select);
            Q[l] = "SELECT";
            l++;
        }else if(preanalisis.equals(distinct)){
            //D
            coincidir(distinct);
            D[l] = "DISTINCT";
            l++;
        }

        if(!hayErrores && !preanalisis.equals(finCadena)){
            System.out.println("Error en la posición " + preanalisis.posicion + ". No se esperaba el token " + preanalisis.tipo);
        }
        else if(!hayErrores && preanalisis.equals(finCadena)){
            System.out.println("Consulta válida");
        }

    }

    

    void coincidir(Token t){
        if(hayErrores) return;

        if(preanalisis.tipo == t.tipo){
            i++;
            preanalisis = tokens.get(i);
        }
        else{
            hayErrores = true;
            System.out.println("Error en la posición " + preanalisis.posicion + ". Se esperaba un  " + t.tipo);

        }
    }
}
