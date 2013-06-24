/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FuenteProyecto;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JComboBox;
/**
 *
 * @author Fernando Valverde y Alexis DevitreBD\\
 */
public class Conexion {
    private static final String nombreConexion = ""; // Poner acá al cargar

    private String hileraResultado;
    
    public Conexion() {
        hileraResultado = "";
    }
    
    public String getHileraResultado() {
        return hileraResultado;
    }
    
    public boolean consulta(String sql) {
        boolean exito = true;
        try {
            //Se abre la conexion utilizando el driver de postgres
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(nombreConexion);
            Statement comando = conexion.createStatement();
            ResultSet resultado = null;
            
            //Se ejecuta la instruccion SQL
            boolean consulta = comando.execute(sql);
            
            if(consulta) {
                //Si el resultado es 'true' significa que hubo una consulta con resultado
                resultado = comando.getResultSet();
                
                //Se saca el MetaData para conocer la informacion del ResultSet
                //El MetaData contiene toda la informacion sobre la tabla generada por la consulta
                ResultSetMetaData metaData = resultado.getMetaData();
                
                //Por ejemplo, sacamos la cantidad de columnas del resultado
                int cantidad= metaData.getColumnCount();
                hileraResultado = "";
                while(resultado.next()){
                    //Se itera uno a uno por las filas (el comando next() cambia de fila)
                    String n = "";
                    for (int i=1; i<=cantidad; i++) {
                        //Se saca la informacion de cada columna
                        n += resultado.getString(i) + " ";
                    }
                    hileraResultado += n + "</br>";
                    //System.out.println(n);
                }
                resultado.close();
            } else {
                //Como no se ejecuto una consulta, no se produjo ningun ResultSet
                hileraResultado = "";
                System.out.println("comando SQL ejecutado correctamente");
            }
            //Hay que cerrar la conexion
            comando.close();
            conexion.close();
        } catch (Exception e) {
            //Es muy importante el try-catch para atrapar los posibles errores
            //que pueden ocurrir en las distintas consultas y comandos SQL
            System.out.println(e.getMessage());
            exito = false;
        }
        //Se retorna si la ejecucion tuvo exito o no
        return exito;
    }
    
    public void llenarCombobox(String sql, JComboBox combobox) {
        try {
            //Se abre la conexion utilizando el driver de postgres
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(nombreConexion);
            Statement comando = conexion.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            //Para cada elemento retornado se agrega al combobox un "item" 
            while(resultado.next()) {
                combobox.addItem(resultado.getString(1));
            }
            
            //Hay que cerrar la conexion
            resultado.close();
            comando.close();
            conexion.close();
        } catch (Exception e) {
            //Es muy importante el try-catch para atrapar los posibles errores
            //que pueden ocurrir en las distintas consultas y comandos SQL
            System.out.println(e.getMessage());
            System.out.println("No GG");
        }
    }
    
    public void llenarTabla(String sql, JTable tabla){
        try {
            //Para manejar los datos en un JTable se utiliza un modelo,
            //que por dejecto es "DefaultTableModel". Sin embargo queremos
            //utilizar uno personalizado para esta aplicación, por eso se creó
            //DBTableModel. Si no está asignado (ni creado) hay que
            //hacerlo, de lo contrario solo hace falta actualizarlo.
            if( (tabla.getModel().getClass().toString()).equalsIgnoreCase("class pruebaconexion.DBTableModel") ) {
                //Se actualiza porque ya existe y lo tiene asignado
                ((DBTableModel) tabla.getModel()).actualizar(sql, nombreConexion);
            } else {
                //Se crea uno nuevo y se asigna
                DBTableModel modelo = new DBTableModel(sql, nombreConexion);
                tabla.setModel(modelo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<ArrayList<String>> consultaGetArrayList(String sql) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        try {
            //Se abre la conexion utilizando el driver de postgres
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(nombreConexion);
            Statement comando = conexion.createStatement();
            ResultSet resultado = null;
            
            //Se ejecuta la instruccion SQL
            boolean consulta = comando.execute(sql);
            
            if(consulta) {
                //Si el resultado es 'true' significa que hubo una consulta con resultado
                resultado = comando.getResultSet();
                
                //Se saca el MetaData para conocer la informacion del ResultSet
                //El MetaData contiene toda la informacion sobre la tabla generada por la consulta
                ResultSetMetaData metaData = resultado.getMetaData();
                
                //Por ejemplo, sacamos la cantidad de columnas del resultado
                int cantidad= metaData.getColumnCount();
                hileraResultado = "";
                while(resultado.next()){
                    //Se itera uno a uno por las filas (el comando next() cambia de fila)
                    res.add(new ArrayList<String>());
                    String n = "";
                    for (int i=1; i<=cantidad; i++){
                        //Se saca la informacion de cada columna
                        res.get(res.size()-1).add(resultado.getString(i));
                    }
                }
                resultado.close();
            } else {
                //Como no se ejecuto una consulta, no se produjo ningun ResultSet
                hileraResultado = "";
                System.out.println("comando SQL ejecutado correctamente");
            }
            //Hay que cerrar la conexion
            comando.close();
            conexion.close();
        } catch (Exception e) {
            //Es muy importante el try-catch para atrapar los posibles errores
            //que pueden ocurrir en las distintas consultas y comandos SQL
            System.out.println(e.getMessage());
            res = null;
        }
        //Se retorna si la ejecucion tuvo exito o no
        return res;
    }
}
