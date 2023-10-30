package actividad1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Interfaz {
	
	private JFrame frame;
	private JPanel panel;
	private JButton botonAnnadir;
	private JButton botonCorregir;
	private JButton botonEliminar;
	private JButton botonResetear;
	private JTable tablaAlumnos;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		Estudiante.estudiantesPorDefecto();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interfaz() {
		IniciarInterfaz();
	}
	
	public void IniciarInterfaz() {
	
	frame = new JFrame();
	frame.setBounds(100, 100, 800, 380);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Alumnos");
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);
	
	botonAnnadir = new JButton("Añadir");
    botonAnnadir.setBounds(50, 20, 150, 30); // Aumenta el ancho del botón
    panel.add(botonAnnadir);

    botonCorregir = new JButton("Editar");
    botonCorregir.setBounds(210, 20, 150, 30); // Aumenta el ancho del botón
    panel.add(botonCorregir);

    botonEliminar = new JButton("Eliminar");
    botonEliminar.setBounds(370, 20, 150, 30); // Aumenta el ancho del botón
    panel.add(botonEliminar);
    
    botonResetear = new JButton("Resetear lista");
    botonResetear.setBounds(530, 20, 150, 30); // Aumenta el ancho del botón
    panel.add(botonResetear);
    
    String[] columnas = {"ID", "Alumno", "Nota"};
    modeloTabla = new DefaultTableModel(columnas, 0) {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public Class getColumnClass(int columnas) {
            switch (columnas) {
                case 0:
                    return Integer.class;
                case 1:
                    return String.class;
                case 2:
                    return Double.class;
                default:
                    return String.class;
            }
        }
    };
    
    tablaAlumnos = new JTable(modeloTabla);
    
    //para poder ordenar la tabla
    
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
    tablaAlumnos.setRowSorter(sorter);
    
    //para poder ajustar el alineamiento horizontal del texto en las celdas de la tabla
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment( JLabel.LEFT );
    tablaAlumnos.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
    tablaAlumnos.getColumnModel().getColumn(1).setCellRenderer( leftRenderer );
    tablaAlumnos.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    
    //para poder subir y bajar en la tabla
    
    JScrollPane scrollPane = new JScrollPane(tablaAlumnos);
    scrollPane.setBounds(50, 70, 700, 200);
    panel.add(scrollPane);
    
    //iteramos en el hashmap para establecer las filas de la tabla por defecto
    
    actualizarTabla();
    
    //de esta forma ordeno por defecto la tabla por el id, columna 0
    sorter.toggleSortOrder(0);
    
    frame.setVisible(true);
	
    /////////////////
    //actionListeners
    /////////////////
    
    botonAnnadir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Crear una nueva ventana para ingresar el nombre y la nota del alumno
            JFrame ventanaAgregarAlumno = new JFrame();
            ventanaAgregarAlumno.setBounds(200, 200, 400, 200);
            ventanaAgregarAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaAgregarAlumno.setTitle("Añadir Alumno");

            JPanel panelAgregarAlumno = new JPanel();
            panelAgregarAlumno.setLayout(null);
            ventanaAgregarAlumno.add(panelAgregarAlumno);

            JLabel labelNombre = new JLabel("Nombre:");
            labelNombre.setBounds(50, 30, 60, 25);
            panelAgregarAlumno.add(labelNombre);

            JTextField textFieldNombre = new JTextField();
            textFieldNombre.setBounds(120, 30, 200, 25);
            panelAgregarAlumno.add(textFieldNombre);

            JLabel labelNota = new JLabel("Nota:");
            labelNota.setBounds(50, 70, 60, 25);
            panelAgregarAlumno.add(labelNota);

            JTextField textFieldNota = new JTextField();
            textFieldNota.setBounds(120, 70, 100, 25);
            panelAgregarAlumno.add(textFieldNota);

            JButton botonEnviar = new JButton("Enviar");
            botonEnviar.setBounds(250, 120, 80, 25);
            panelAgregarAlumno.add(botonEnviar);

            // Configurar el ActionListener para el botón "Enviar"
            botonEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el nombre y la nota del JTextField y llamar al método annadirEstudiante
                    String nombre = textFieldNombre.getText();
                    double nota = Double.parseDouble(textFieldNota.getText());

                    // Llamar al método annadirEstudiante con los valores ingresados
                    Estudiante.annadirEstudiante(nombre, nota);
                    
                    //actualizo la tabla
                    actualizarTabla();
                    
                    // Cerrar la ventana después de hacer clic en "Enviar"
                    ventanaAgregarAlumno.dispose();
                }
            });

            ventanaAgregarAlumno.setVisible(true);
        }
    });
    
    botonCorregir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Crear una nueva ventana para ingresar el ID del alumno
            JFrame ventanaCorregirAlumno = new JFrame();
            ventanaCorregirAlumno.setBounds(200, 200, 400, 250);
            ventanaCorregirAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaCorregirAlumno.setTitle("Corregir Alumno");

            JPanel panelCorregirAlumno = new JPanel();
            panelCorregirAlumno.setLayout(null);
            ventanaCorregirAlumno.add(panelCorregirAlumno);

            JLabel labelId = new JLabel("ID:");
            labelId.setBounds(50, 30, 60, 25);
            panelCorregirAlumno.add(labelId);
            
             JTextField textFieldId = new JTextField();
            textFieldId.setBounds(120, 30, 100, 25);
            panelCorregirAlumno.add(textFieldId);
            
            JButton botonBuscar = new JButton("Buscar");
            botonBuscar.setBounds(230, 30, 80, 25);
            panelCorregirAlumno.add(botonBuscar);

            

            JLabel labelNombre = new JLabel("Nombre:");
            labelNombre.setBounds(50, 70, 60, 25);
            panelCorregirAlumno.add(labelNombre);

            JTextField textFieldNombre = new JTextField();
            textFieldNombre.setBounds(120, 70, 200, 25);
            panelCorregirAlumno.add(textFieldNombre);
            textFieldNombre.setEnabled(false); // Deshabilitar el campo de texto

            JLabel labelNota = new JLabel("Nota:");
            labelNota.setBounds(50, 110, 60, 25);
            panelCorregirAlumno.add(labelNota);

            JTextField textFieldNota = new JTextField();
            textFieldNota.setBounds(120, 110, 100, 25);
            panelCorregirAlumno.add(textFieldNota);
            textFieldNota.setEnabled(false); // Deshabilitar el campo de texto

            JButton botonEnviar = new JButton("Enviar");
            botonEnviar.setBounds(250, 150, 80, 25);
            panelCorregirAlumno.add(botonEnviar);
            
         // Configurar el ActionListener para el botón "Buscar"
            botonBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el ID del JTextField
                    int idBuscado = Integer.parseInt(textFieldId.getText());
                    
                    // Iterar sobre el mapa de alumnos y notas usando el iterador proporcionado
                    Iterator<Map.Entry<Estudiante, Double>> iterator = Estudiante.mapaAlumnosNota.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Estudiante, Double> entry = iterator.next();
                        Estudiante estudiante = entry.getKey();
                        
                        // Comprobar si el ID coincide con el ID buscado
                        if (estudiante.getId() == idBuscado) {
                            // Obtener el nombre y la nota del estudiante y mostrarlos en los campos de texto
                            String nombre = estudiante.getNombre();
                            double nota = entry.getValue();
                            
                            // Habilitar los campos de texto y mostrar el nombre y la nota del estudiante
                            textFieldNombre.setEnabled(true);
                            textFieldNota.setEnabled(true);
                            textFieldNombre.setText(nombre);
                            textFieldNota.setText(String.valueOf(nota));
                            
                            // Salir del bucle ya que se encontró el estudiante
                            break;
                        }
                    }
                }
            });

            // Configurar el ActionListener para el botón "Enviar"
            botonEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el nuevo nombre y nota del JTextField y llamar al método editarEstudiante
                    String nuevoNombre = textFieldNombre.getText();
                    double nuevaNota = Double.parseDouble(textFieldNota.getText());

                    // Llamar al método editarEstudiante con los valores ingresados
                    // estudiante.editarEstudiante(nuevoNombre, nuevaNota);

                    // Actualizar la tabla
                    actualizarTabla();

                    // Cerrar la ventana después de hacer clic en "Enviar"
                    ventanaCorregirAlumno.dispose();
                }
            });

            ventanaCorregirAlumno.setVisible(true);
        }
    });
    
	}
	
	private void actualizarTabla() {
        modeloTabla.setRowCount(0); // Limpiar la tabla
        Iterator<Map.Entry<Estudiante, Double>> iterator = Estudiante.mapaAlumnosNota.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Estudiante, Double> entry = iterator.next();
            int id = entry.getKey().getId();
            String nombre = entry.getKey().getNombre();
            Double nota = entry.getValue(); //realmente aqui el uso del hashmap no merece mucho, ya que he hecho una clase estudiante
            								//y acceder a sus datos es tan facil como usar los getters de la clase
            								//en resumen: como lo he hecho, no hay diferencia en usar aqui un arraylist o un hashmap
            Object[] fila = {id, nombre, nota};
            modeloTabla.addRow(fila);
        }
	
}
	
}
