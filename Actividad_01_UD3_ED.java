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

    public static void inicializarArchivos() throws FileNotFoundException
    {
        setFlujoEntrada(new FileInputStream(getNombreArchivo()));
        setBuferDeEntrada(new BufferedInputStream(getFlujoEntrada()));
    }
    
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
     * @return the bufer
     */
    public static byte[] getBufer() {
        return bufer;
    }

    /**
     * @param aBufer the bufer to set
     */
    public static void setBufer(byte[] aBufer) {
        bufer = aBufer;
    }

    /**
     * @return the nombreArchivo
     */
    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    
    public static void setNombreArchivo(String aNombreArchivo) {
        nombreArchivo = aNombreArchivo;
    }

    /**
     * @return the flujoEntrada
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
     * @return the buferDeEntrada
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
