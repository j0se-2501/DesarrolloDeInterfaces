package actividad2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
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

public class Principal {
	
	
	//interfaz
	private JFrame frame;
	private JPanel panel;
	private JButton botonAnnadir;
	private JButton botonEliminar;
	private JButton botonResetear;
	private JButton botonStock;
	private JTable tablaFlores;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private String florKey;
	private int stockValue;
	
	//flores
	public static HashMap <String, Integer> mapaFlorStock = new HashMap<>();
	public static String[] nombres = {"Rosa", "Amapola", "Tulipán", "Lirio", "Margarita",
            "Orquídea", "Girasol", "Clavel", "Dalia", "Peonía",
            "Lavanda", "Jazmín", "Narciso", "Petunia", "Hortensia",
            "Crótalo", "Begonia", "Caléndula", "Camelia", "Diente de León"};
	
	public static void main(String[] args) {
		rellenarMapa();
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Alumnos");
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		botonAnnadir = new JButton("Nueva flor");
	    botonAnnadir.setBounds(50, 20, 150, 30);
	    panel.add(botonAnnadir);
	    
	    botonStock = new JButton("Vender flor");
	    botonStock.setBounds(210, 20, 150, 30);
	    panel.add(botonStock);

	    botonEliminar = new JButton("Eliminar flor");
	    botonEliminar.setBounds(370, 20, 150, 30);
	    panel.add(botonEliminar);
	    
	    botonResetear = new JButton("Resetear lista");
	    botonResetear.setBounds(530, 20, 150, 30);
	    panel.add(botonResetear);
	    
	    String[] columnas = {"Flor", "Stock"};
	    modeloTabla = new DefaultTableModel(columnas, 0) {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public Class getColumnClass(int columnas) {
	            switch (columnas) {
	                case 0:
	                    return String.class;
	                case 1:
	                    return Integer.class;
	                default:
	                    return String.class;
	            }
	        }
	    };
	    
	    tablaFlores = new JTable(modeloTabla);
	    
	    //para poder ordenar la tabla
	    
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
	    tablaFlores.setRowSorter(sorter);
	    
	    //para poder ajustar el alineamiento horizontal del texto en las celdas de la tabla
	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
	    leftRenderer.setHorizontalAlignment( JLabel.LEFT );
	    tablaFlores.getColumnModel().getColumn(0).setCellRenderer( leftRenderer );
	    tablaFlores.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
	    
	    //para poder subir y bajar en la tabla
	    
	    scrollPane = new JScrollPane(tablaFlores);
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
			        //creo una nueva ventana para ingresar el nombre de la nueva flor
			        JFrame ventanaAgregarFlor = new JFrame();
			        ventanaAgregarFlor.setBounds(200, 200, 400, 200);
			        ventanaAgregarFlor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        ventanaAgregarFlor.setTitle("Añadir flor");

			        JPanel panelAgregarFlor = new JPanel();
			        panelAgregarFlor.setLayout(null);
			        ventanaAgregarFlor.add(panelAgregarFlor);

			        JLabel labelNombre = new JLabel("Nombre:");
			        labelNombre.setBounds(50, 30, 60, 25);
			        panelAgregarFlor.add(labelNombre);

			        JTextField textFieldNombre = new JTextField();
			        textFieldNombre.setBounds(120, 30, 200, 25);
			        panelAgregarFlor.add(textFieldNombre);

			        JLabel labelStock = new JLabel("Stock:");
			        labelStock.setBounds(50, 70, 60, 25);
			        panelAgregarFlor.add(labelStock);

			        JTextField textFieldStock = new JTextField();
			        textFieldStock.setBounds(120, 70, 100, 25);
			        panelAgregarFlor.add(textFieldStock);

			        JButton botonEnviar = new JButton("Enviar");
			        botonEnviar.setBounds(250, 120, 80, 25);
			        panelAgregarFlor.add(botonEnviar);

			        //boton enviar para confirmar los datos de la nueva flor
			        botonEnviar.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	
			            	 try {
			                //meto los datos en el hashmap
			                mapaFlorStock.put(textFieldNombre.getText(), Integer.parseInt(textFieldStock.getText()));
			                
			                //actualizo la tabla
			                actualizarTabla();
			                
			                //se cierra la ventana
			                ventanaAgregarFlor.dispose();
			               
			            	} catch (NumberFormatException e2) {
			        		int input = JOptionPane.showConfirmDialog(null, 
			                        "Introduzca valores correctos", "Error", JOptionPane.DEFAULT_OPTION);
			        		e2.printStackTrace();
			        	}
			                
			            }
			        });

			        ventanaAgregarFlor.setVisible(true);
			    }
			});
		
	    
	    botonStock.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //ventana nueva para editar el stock de la flor
	            JFrame ventanaModificarStock = new JFrame();
	            ventanaModificarStock.setBounds(200, 200, 400, 250);
	            ventanaModificarStock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            ventanaModificarStock.setTitle("Vender flor");

	            JPanel panelModificarStock = new JPanel();
	            panelModificarStock.setLayout(null);
	            ventanaModificarStock.add(panelModificarStock);

	            JLabel labelNombre = new JLabel("Nombre:");
	            labelNombre.setBounds(50, 30, 60, 25);
	            panelModificarStock.add(labelNombre);
	            
	            JTextField textFieldNombre = new JTextField();
	            textFieldNombre.setBounds(120, 30, 100, 25);
	            panelModificarStock.add(textFieldNombre);
	            
	            JButton botonBuscar = new JButton("Buscar"); //primero busco el nombre de la flor, y al encontrarla muestro sus datos
	            botonBuscar.setBounds(230, 30, 80, 25);
	            panelModificarStock.add(botonBuscar);

	            JLabel labelStock = new JLabel("Uds.");
	            labelStock.setBounds(50, 110, 60, 25);
	            panelModificarStock.add(labelStock);

	            JTextField textFieldStock = new JTextField();
	            textFieldStock.setBounds(120, 110, 100, 25);
	            panelModificarStock.add(textFieldStock);
	            textFieldStock.setEnabled(false); //disabled a no ser que se encuentre la flor

	            JButton botonEnviar = new JButton("Enviar"); //y lo mismo con el boton para confirmar los cambios
	            botonEnviar.setBounds(250, 150, 80, 25);
	            panelModificarStock.add(botonEnviar);
	            botonEnviar.setEnabled(false);
	            
	            botonBuscar.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    
	                    try {
							String nombreBuscado = textFieldNombre.getText();//cojo el nombre del textfield
							
							//itero sobre el mapa de flores y stock con iterator
							Iterator<Map.Entry<String, Integer>> iterator = mapaFlorStock.entrySet().iterator();
							while (iterator.hasNext()) {
							    Map.Entry<String, Integer> entry = iterator.next();
							    
							    florKey = entry.getKey();
							    stockValue = entry.getValue();
							    
							    if (florKey.equals(nombreBuscado)) { //compruebo si el nombre coincide con el nombre buscado
							        
							        //habilito los campos y el boton deshabilitados
							        textFieldStock.setEnabled(true);
							        botonEnviar.setEnabled(true);
							        
							        //salgo del bucle
							        break;
							    } else {
							    	
							    	//si no se encuentra, siguen disabled
							    	textFieldStock.setEnabled(false);
							        botonEnviar.setEnabled(false);
							    }
							}
							if(!iterator.hasNext()) JOptionPane.showMessageDialog(null, //en caso de que no se encuentre la flor
    	                            "Flor no encontrada");
						} catch (NumberFormatException e1) {
							int input = JOptionPane.showConfirmDialog(null, 
			                        "Introduzca valores correctos.", "Error", JOptionPane.DEFAULT_OPTION);
							e1.printStackTrace();
						}
	                }
	            });

	            botonEnviar.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    
	                    try {
	                    	
	                    	if (stockValue >= Integer.parseInt(textFieldStock.getText())) {
	                    	
	                    	mapaFlorStock.put(florKey, (stockValue-Integer.parseInt(textFieldStock.getText())));

							// Actualizar la tabla
							actualizarTabla();

							//cierro la ventana
							ventanaModificarStock.dispose();
							
	                    	} else {
	                    		
	                    		JOptionPane.showMessageDialog(null, //si las uds vendidas superar al stock, salta esta ventana
	    	                            "Stock insuficiente.");
	                    		
	                    	}
						} catch (NumberFormatException e1) {
							int input = JOptionPane.showConfirmDialog(null, 
			                        "Introduzca valores correctos.", "Error", JOptionPane.DEFAULT_OPTION);
							e1.printStackTrace();
						}
	                }
	            });

	            ventanaModificarStock.setVisible(true);
	        }
	    });
	    
	    botonEliminar.addActionListener(new ActionListener() { //boton para eliminar una flor
	    												
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            JFrame ventanaEliminarFlor = new JFrame();
	            ventanaEliminarFlor.setBounds(200, 200, 400, 250);
	            ventanaEliminarFlor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            ventanaEliminarFlor.setTitle("Eliminar Flor");

	            JPanel panelEliminarFlor = new JPanel();
	            panelEliminarFlor.setLayout(null);
	            ventanaEliminarFlor.add(panelEliminarFlor);

	            JLabel labelNombre = new JLabel("Nombre:");
	            labelNombre.setBounds(50, 30, 60, 25);
	            panelEliminarFlor.add(labelNombre);
	            
	            JTextField textFieldNombre = new JTextField();
	            textFieldNombre.setBounds(120, 30, 100, 25);
	            panelEliminarFlor.add(textFieldNombre);
	            
	            JButton botonEliminar = new JButton("Eliminar");
	            botonEliminar.setBounds(250, 150, 80, 25);
	            panelEliminarFlor.add(botonEliminar);
	            
	            botonEliminar.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	
	                	Iterator<Map.Entry<String, Integer>> iterator = mapaFlorStock.entrySet().iterator();
	            		while (iterator.hasNext()) {
	            		    Map.Entry<String, Integer> entry = iterator.next();
	            		    
	            		    String florKey = entry.getKey();
	            		   
	            		    if (florKey.equalsIgnoreCase(textFieldNombre.getText())) {
	            		        
	            		    	int confirmacion = JOptionPane.showConfirmDialog(null, //panel de confirmacion de eliminacion
	    	                            "¿Estás seguro de que deseas eliminar esta flor?", "Eliminar",
	    	                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            		    	
	    	                    //si se pulsa que si en la confirmacion
	    	                    if (confirmacion == JOptionPane.YES_OPTION) {
	    	                    	
	    	                    	 mapaFlorStock.remove(florKey); //elimino la flor

	    	                        actualizarTabla(); //actualizo la tabla

	    	                        ventanaEliminarFlor.dispose(); //cierro la ventana
	            		        
	            		        //salgo del bucle
	            		        break;
	            		    } else { 
	            		    	
	            		    }
	            		
	                	
	            		    }

	            		} if (!iterator.hasNext()) {
	            			JOptionPane.showMessageDialog(null, //si no existe la flor, salta esta ventana
    	                            "Flor no encontrada");
	            		}
	                }
	                
	            });

	            ventanaEliminarFlor.setVisible(true);
	        }
	    });
	    
	    botonResetear.addActionListener(new ActionListener() { //igual que la confirmacion de eliminar pero directamente para resetear
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	int confirmacion = JOptionPane.showConfirmDialog(null,
	                    "¿Estás seguro de que deseas resetear la lista?", "Resetear lista",
	                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	            if (confirmacion == JOptionPane.YES_OPTION) {
	                
	                rellenarMapa();

	                actualizarTabla();

	             }

	          
	        }
	    });
	    
		}

private void actualizarTabla() {
    modeloTabla.setRowCount(0); //limpio la tabla
    Iterator<Map.Entry<String, Integer>> iterator = mapaFlorStock.entrySet().iterator(); //itero sobre el hashmap
    while (iterator.hasNext()) {
        Map.Entry<String, Integer> entry = iterator.next();
        String florKey = entry.getKey();
        int stockValue = entry.getValue();
        
        Object[] fila = {florKey, stockValue}; //creo cada fila de la tabla asi al coger los datos de cada entrada del mapa; cogido del chatGPT
        modeloTabla.addRow(fila);
    }

}
	
	public static void rellenarMapa() {
		
		mapaFlorStock.clear();
		
		for (int i=0; i<nombres.length; i++) {
			int stock = (int) (Math.random() * 101);
			mapaFlorStock.put(nombres[i], stock);
		}
		
	}
	

}

