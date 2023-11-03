package actividad1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

//me he sobrecomplicado creando una clase estudiante de forma que no tiene sentido el ejercicio

public class Principal {
	
	private JFrame frame;
	private JPanel panel;
	private JButton botonAnnadir;
	private JButton botonCorregir;
	private JButton botonEliminar;
	private JButton botonResetear;
	private JTable tablaAlumnos;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private Estudiante estudiante;
	
	public static void main(String[] args) {
		Estudiante.estudiantesPorDefecto();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
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
    
    scrollPane = new JScrollPane(tablaAlumnos);
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
		        //creo una nueva ventana para ingresar el nombre y la nota del alumno
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

		        //boton enviar para confirmar los datos del nuevo alumno
		        botonEnviar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	
		            	 try {
		                //guardo el nombre y la nota para el metodo annadirEstudiante
		                String nombre = textFieldNombre.getText();
		                double nota = Double.parseDouble(textFieldNota.getText());

		                //annado el estudiante al hashmap
		                Estudiante.annadirEstudiante(nombre, nota);
		                
		                //actualizo la tabla
		                actualizarTabla();
		                
		                //se cierra la ventana
		                ventanaAgregarAlumno.dispose();
		               
		            	} catch (NumberFormatException e2) {
		        		int input = JOptionPane.showConfirmDialog(null, 
		                        "Introduzca valores correctos", "Error", JOptionPane.DEFAULT_OPTION);
		        		e2.printStackTrace();
		        	}
		                
		            }
		        });

		        ventanaAgregarAlumno.setVisible(true);
		    }
		});
	
    
    botonCorregir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //ventana nueva para editar los datos del alumno
            JFrame ventanaCorregirAlumno = new JFrame();
            ventanaCorregirAlumno.setBounds(200, 200, 400, 250);
            ventanaCorregirAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaCorregirAlumno.setTitle("Editar Alumno");

            JPanel panelCorregirAlumno = new JPanel();
            panelCorregirAlumno.setLayout(null);
            ventanaCorregirAlumno.add(panelCorregirAlumno);

            JLabel labelId = new JLabel("ID:");
            labelId.setBounds(50, 30, 60, 25);
            panelCorregirAlumno.add(labelId);
            
            JTextField textFieldId = new JTextField();
            textFieldId.setBounds(120, 30, 100, 25);
            panelCorregirAlumno.add(textFieldId);
            
            JButton botonBuscar = new JButton("Buscar"); //primero busco una id, y al encontrarla muestro los datos del estudiante
            botonBuscar.setBounds(230, 30, 80, 25);
            panelCorregirAlumno.add(botonBuscar);

            JLabel labelNombre = new JLabel("Nombre:");
            labelNombre.setBounds(50, 70, 60, 25);
            panelCorregirAlumno.add(labelNombre);

            JTextField textFieldNombre = new JTextField();
            textFieldNombre.setBounds(120, 70, 200, 25);
            panelCorregirAlumno.add(textFieldNombre);
            textFieldNombre.setEnabled(false); //no dejo actualizar los campos hasta que no se encuentre un alumno con esa id

            JLabel labelNota = new JLabel("Nota:");
            labelNota.setBounds(50, 110, 60, 25);
            panelCorregirAlumno.add(labelNota);

            JTextField textFieldNota = new JTextField();
            textFieldNota.setBounds(120, 110, 100, 25);
            panelCorregirAlumno.add(textFieldNota);
            textFieldNota.setEnabled(false); //lo mismo con la nota

            JButton botonEnviar = new JButton("Enviar"); //y lo mismo con el boton para confirmar los cambios
            botonEnviar.setBounds(250, 150, 80, 25);
            panelCorregirAlumno.add(botonEnviar);
            botonEnviar.setEnabled(false);
            
            estudiante = new Estudiante(); //creo un estudiante vacio para iterar sobre el
            
            botonBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
						int idBuscado = Integer.parseInt(textFieldId.getText());//cojo el id del textfield
						
						//itero sobre el mapa de alumnos y notas con iterator
						Iterator<Map.Entry<Estudiante, Double>> iterator = Estudiante.mapaAlumnosNota.entrySet().iterator();
						while (iterator.hasNext()) {
						    Map.Entry<Estudiante, Double> entry = iterator.next();
						    estudiante = entry.getKey();
						    
						    if (estudiante.getId() == idBuscado) { //compruebo si el ID coincide con el ID buscado
						        
						        String nombre = estudiante.getNombre(); //cojo el nombre y la nota del estudiante y los muestro en los campos de texto
						        double nota = entry.getValue();
						        
						        
						        textFieldNombre.setEnabled(true); //habilito los campos y el boton deshabilitados
						        textFieldNota.setEnabled(true);
						        textFieldNombre.setText(nombre);
						        textFieldNota.setText(String.valueOf(nota));
						        botonEnviar.setEnabled(true);
						        
						        //salgo del bucle
						        break;
						    } else {
						    	textFieldNombre.setEnabled(false);
						        textFieldNota.setEnabled(false);
						        botonEnviar.setEnabled(false);
						    }
						}
					} catch (NumberFormatException e1) {
						int input = JOptionPane.showConfirmDialog(null, 
		                        "Introduzca valores correctos", "Error", JOptionPane.DEFAULT_OPTION);
						e1.printStackTrace();
					}
                }
            });

            botonEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
						String nuevoNombre = textFieldNombre.getText(); //cojo el nuevo nombre y nota de los JTextField
						double nuevaNota = Double.parseDouble(textFieldNota.getText());

						
						Estudiante.editarEstudiante(estudiante.getId(), nuevoNombre, nuevaNota); //edito al estudiante
						// Actualizar la tabla
						actualizarTabla();

						//cierro la ventana
						ventanaCorregirAlumno.dispose();
					} catch (NumberFormatException e1) {
						int input = JOptionPane.showConfirmDialog(null, 
		                        "Introduzca valores correctos", "Error", JOptionPane.DEFAULT_OPTION);
						e1.printStackTrace();
					}
                }
            });

            ventanaCorregirAlumno.setVisible(true);
        }
    });
    
    botonEliminar.addActionListener(new ActionListener() { //boton para eliminar un alumno
    													//igual que cuando edito alumno, primero busco la id, y entonces habilito los textos
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            JFrame ventanaEliminarAlumno = new JFrame();
            ventanaEliminarAlumno.setBounds(200, 200, 400, 250);
            ventanaEliminarAlumno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaEliminarAlumno.setTitle("Eliminar Alumno");

            JPanel panelEliminarAlumno = new JPanel();
            panelEliminarAlumno.setLayout(null);
            ventanaEliminarAlumno.add(panelEliminarAlumno);

            JLabel labelId = new JLabel("ID:");
            labelId.setBounds(50, 30, 60, 25);
            panelEliminarAlumno.add(labelId);
            
             JTextField textFieldId = new JTextField();
            textFieldId.setBounds(120, 30, 100, 25);
            panelEliminarAlumno.add(textFieldId);
            
            JButton botonBuscar = new JButton("Buscar");
            botonBuscar.setBounds(230, 30, 80, 25);
            panelEliminarAlumno.add(botonBuscar);

            

            JLabel labelNombre = new JLabel("Nombre:");
            labelNombre.setBounds(50, 70, 60, 25);
            panelEliminarAlumno.add(labelNombre);

            JLabel textFieldNombre = new JLabel();
            textFieldNombre.setBounds(120, 70, 200, 25);
            panelEliminarAlumno.add(textFieldNombre);
            textFieldNombre.setEnabled(false); //unabled hasta que se encuentre el id del alumno

            JLabel labelNota = new JLabel("Nota:");
            labelNota.setBounds(50, 110, 60, 25);
            panelEliminarAlumno.add(labelNota);

            JLabel textFieldNota = new JLabel();
            textFieldNota.setBounds(120, 110, 100, 25);
            panelEliminarAlumno.add(textFieldNota);
            textFieldNota.setEnabled(false);

            JButton botonEliminar2 = new JButton("Eliminar");
            botonEliminar2.setBounds(250, 150, 80, 25);
            panelEliminarAlumno.add(botonEliminar2);
            botonEliminar2.setEnabled(false);
            
            estudiante = new Estudiante();
            
            botonBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
						//obtengo el ID del JTextField
						int idBuscado = Integer.parseInt(textFieldId.getText());
						
						//itero sobre el mapa de alumnos y notas usando el iterador proporcionado
						Iterator<Map.Entry<Estudiante, Double>> iterator = Estudiante.mapaAlumnosNota.entrySet().iterator();
						while (iterator.hasNext()) {
						    Map.Entry<Estudiante, Double> entry = iterator.next();
						    estudiante = entry.getKey();
						    
						    //compruebo si el ID coincide con el ID buscado
						    if (estudiante.getId() == idBuscado) {
						        //cojo el nombre y la nota del estudiante y los muestro en los campos de texto
						        String nombre = estudiante.getNombre();
						        double nota = entry.getValue();
						        
						        //pongo enabled los campos de texto y muestro el nombre y la nota del estudiante
						        textFieldNombre.setEnabled(true);
						        textFieldNota.setEnabled(true);
						        textFieldNombre.setText(nombre);
						        textFieldNota.setText(String.valueOf(nota));
						        botonEliminar2.setEnabled(true);
						        
						        //salgo del bucle
						        break;
						    } else { //si no encuentro el id, siguen disabled
						    	textFieldNombre.setEnabled(false);
						        textFieldNota.setEnabled(false);
						        botonEliminar2.setEnabled(false);
						    }
						}
					} catch (NumberFormatException e1) {
						int input = JOptionPane.showConfirmDialog(null, 
		                        "Introduzca valores correctos", "Error", JOptionPane.DEFAULT_OPTION);
						e1.printStackTrace();
					}
                }
            });

            
            botonEliminar2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	int confirmacion = JOptionPane.showConfirmDialog(null, //panel de confirmacion de eliminacion
                            "¿Estás seguro de que deseas eliminar al alumno?", "Eliminar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    //si se pulsa que si en la confirmacion
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        
                        Estudiante.eliminarEstudiante(estudiante.getId()); //elimino al estudiante

                        actualizarTabla(); //actualizo la tabla

                        ventanaEliminarAlumno.dispose(); //cierro la ventana
                    }

                  
                }
                
            });

            ventanaEliminarAlumno.setVisible(true);
        }
    });
    
    botonResetear.addActionListener(new ActionListener() { //igual que la confirmacion de eliminar pero directamente para resetear
    	@Override
        public void actionPerformed(ActionEvent e) {
        	
        	int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de que deseas resetear la lista?", "Resetear lista",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmacion == JOptionPane.YES_OPTION) {
                
                Estudiante.estudiantesPorDefecto();

                actualizarTabla();

             }

          
        }
    });
    
	}
	
	private void actualizarTabla() {
        modeloTabla.setRowCount(0); //limpio la tabla
        Iterator<Map.Entry<Estudiante, Double>> iterator = Estudiante.mapaAlumnosNota.entrySet().iterator(); //itero sobre el hashmap
        while (iterator.hasNext()) {
            Map.Entry<Estudiante, Double> entry = iterator.next();
            int id = entry.getKey().getId();
            String nombre = entry.getKey().getNombre();
            Double nota = entry.getValue(); 
            
            Object[] fila = {id, nombre, nota}; //creo cada fila de la tabla asi al coger los datos de cada entrada del mapa; cogido del chatGPT
            modeloTabla.addRow(fila);
        }
	
	}
	
}
