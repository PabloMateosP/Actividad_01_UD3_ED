/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Pablo Mateos Palas
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream buferDeEntrada = null;
    /**
     *
     * @throws FileNotFoundException mediante este throws lo que declaramos es una excepción para que si no apareciesen los parámetros requeridos no funcionase 
     */
    public static void inicializarArchivos() throws FileNotFoundException
    {
        setFlujoEntrada(new FileInputStream(getNombreArchivo()));
        setBuferDeEntrada(new BufferedInputStream(getFlujoEntrada()));
    }
    
    /**
     *
     * @return Nuestro return nos devuelve el total de texto de nuestro archivo 
     * @throws IOException Mediante esta palabra declaramos un restricción
     */
    public static int mostrarTextoDeArchivo() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = getFlujoEntrada().read(getBufer())) != -1) 
        {
            System.out.println(new String(getBufer()));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarTextoDeArchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( getBuferDeEntrada() != null && getFlujoEntrada() != null )
                {
                    getFlujoEntrada().close();
                    getBuferDeEntrada().close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }

    /**
     * @return the bufer. Con este return lo que nuestro programa hace es devolvernos es el bufer presente.
     */
    public static byte[] getBufer() {
        return bufer;
    }

    /**
     * @param aBufer con esta igualdad entre bufer = aBufer lo que comparamos e igualamos ambas palabras.
     */
    public static void setBufer(byte[] aBufer) {
        bufer = aBufer;
    }

    /**
     * @return the nombreArchivo, el return presente nos devuelve el nombre del archivo 
     */
    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     *
     * @param aNombreArchivo, al igual que con el aBufer lo que hacemos es comparar e igualar las palabras dandole el valor de una a la otra.
     */
    public static void setNombreArchivo(String aNombreArchivo) {
        nombreArchivo = aNombreArchivo;
    }

    /**
     * @return the flujoEntrada, mediante este return devolvemos el flujo de Entrada en nuestro método 
     */
    public static FileInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    /**
     * @param aFlujoEntrada the flujoEntrada to set
     */
    public static void setFlujoEntrada(FileInputStream aFlujoEntrada) {
        flujoEntrada = aFlujoEntrada;
    }

    /**
     * @return the buferDeEntrada, mediante el return devolvemos el bufer de entrada en nuestro método 
     */
    public static BufferedInputStream getBuferDeEntrada() {
        return buferDeEntrada;
    }

    /**
     * @param aBuferDeEntrada the buferDeEntrada to set
     */
    public static void setBuferDeEntrada(BufferedInputStream aBuferDeEntrada) {
        buferDeEntrada = aBuferDeEntrada;
    }
    
}
