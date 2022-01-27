package com.main;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.TableOrder;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends JFrame {
	static final int ANCHO = 400;
	static final int ALTO = 450;
	private JLabel lblImagen;
	private JLabel lblSeleccionPizza;
	private JLabel lblSeleccionGrafica;
	private JButton btnEnviar;
	private JButton btnMostrarResultado;
	private JScrollPane scrpContenedor;
	private JCheckBox chckbxDomicilio;

	public static int contMargarita = 6;
	public static int contBarbacoa = 3;
	public static int contHawaiana = 2;
	public static int contVegetariana = 1;
	public static int contCalzone = 4;
	public static int contMarinera = 7;
	public static int contCuatroQuesos = 1;
	public static int contProsciutto = 5;

	public static int contMargaritaDom = 8;
	public static int contBarbacoaDom = 5;
	public static int contHawaianaDom = 6;
	public static int contVegetarianaDom = 3;
	public static int contCalzoneDom = 2;
	public static int contMarineraDom = 4;
	public static int contCuatroQuesosDom = 4;
	public static int contProsciuttoDom = 1;

	/*
	 * public static int contMargarita = 0; public static int contBarbacoa =0;
	 * public static int contHawaiana =0; public static int contVegetariana =0;
	 * public static int contCalzone =0; public static int contMarinera =0; public
	 * static int contCuatroQuesos =0; public static int contProsciutto =0;
	 * 
	 * public static int contMargaritaDom = 0; public static int contBarbacoaDom =0;
	 * public static int contHawaianaDom =0; public static int contVegetarianaDom
	 * =0; public static int contCalzoneDom =0; public static int contMarineraDom
	 * =0; public static int contCuatroQuesosDom =0; public static int
	 * contProsciuttoDom =0;
	 */
	private static boolean domicilio = false;

	public VentanaPrincipal() {
		setTitle("AMANTES DE LA PIZZA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/com/res/appicon.ico")));
		setForeground(new Color(255, 105, 180));
		getContentPane().setBackground(new Color(255, 228, 225));
		setBackground(new Color(220, 20, 60));
		getIinit();

	}

	private void getIinit() {

		getContentPane().setLayout(null);

		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 0, 0);
		getContentPane().add(scrpContenedor);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(ANCHO, ALTO);

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(null);

		JComboBox cmbSelPizza = new JComboBox();
		cmbSelPizza.setForeground(new Color(153, 0, 0));
		cmbSelPizza.setBackground(new Color(204, 204, 204));
		cmbSelPizza.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		cmbSelPizza.setModel(new DefaultComboBoxModel(new String[] { "Margarita", "Barbacoa", "Hawaiana", "Vegetaria",
				"Calzone", "Marinera", "Cuatro Quesos", "Prosciutto" }));
		cmbSelPizza.setBounds(124, 158, 126, 29);
		getContentPane().add(cmbSelPizza);

		JComboBox cmbSelGrafica = new JComboBox();
		cmbSelGrafica.setForeground(new Color(153, 0, 0));
		cmbSelGrafica.setBackground(new Color(204, 204, 204));
		cmbSelGrafica.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		cmbSelGrafica.setModel(new DefaultComboBoxModel(new String[] { "Circular", "Area", "Barras", "Linear" }));
		cmbSelGrafica.setBounds(124, 309, 126, 29);
		getContentPane().add(cmbSelGrafica);

		lblImagen = new JLabel(".");
		lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/res/logo.png")));
		lblImagen.setBounds(-10, 11, 384, 116);
		getContentPane().add(lblImagen);

		lblSeleccionPizza = new JLabel("\u00BFQu\u00E9 pizza suele pedir?");
		lblSeleccionPizza.setForeground(new Color(204, 0, 0));
		lblSeleccionPizza.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		lblSeleccionPizza.setBounds(84, 122, 266, 29);
		getContentPane().add(lblSeleccionPizza);

		chckbxDomicilio = new JCheckBox("A domicilio");
		chckbxDomicilio.setForeground(new Color(204, 0, 0));
		chckbxDomicilio.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		chckbxDomicilio.setBackground(new Color(255, 228, 225));
		chckbxDomicilio.setBounds(111, 194, 139, 23);
		chckbxDomicilio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				domicilio = !domicilio;

			}
		});
		getContentPane().add(chckbxDomicilio);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(204, 204, 204));
		btnEnviar.setForeground(new Color(153, 0, 0));
		btnEnviar.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int valor = cmbSelPizza.getSelectedIndex();

				if (!domicilio) {
					switch (valor) {
					case 0:
						contMargarita++;
						break;
					case 1:
						contBarbacoa++;
						break;
					case 2:
						contHawaiana++;
						break;
					case 3:
						contVegetariana++;
						break;
					case 4:
						contCalzone++;
						break;
					case 5:
						contMarinera++;
						break;
					case 6:
						contCuatroQuesos++;
						break;
					case 7:
						contProsciutto++;
						break;
					}
				} else {
					switch (valor) {
					case 0:
						contMargaritaDom++;
						break;
					case 1:
						contBarbacoaDom++;
						break;
					case 2:
						contHawaianaDom++;
						break;
					case 3:
						contVegetarianaDom++;
						break;
					case 4:
						contCalzoneDom++;
						break;
					case 5:
						contMarineraDom++;
						break;
					case 6:
						contCuatroQuesosDom++;
						break;
					case 7:
						contProsciuttoDom++;
						break;
					}
				}

			}
		});
		btnEnviar.setBounds(124, 224, 126, 29);
		getContentPane().add(btnEnviar);

		btnMostrarResultado = new JButton("Calcular\r\n Resultados");
		btnMostrarResultado.setBackground(new Color(204, 204, 204));
		btnMostrarResultado.setForeground(new Color(153, 0, 0));
		btnMostrarResultado.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		btnMostrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cmbSelGrafica.getSelectedIndex()) {
				case 0:
					grafico(1);
					break;

				case 1:
					grafico(2);
					break;
				case 2:
					grafico(3);
					break;

				case 3:
					grafico(4);
					break;

				}
			}

			private void grafico(int param) {
				DefaultCategoryDataset dataset = crearDataSet();

				switch (param) {
				case 1:
					JFreeChart graficoCircular = ChartFactory.createMultiplePieChart("Pizzas favoritas", dataset,
							TableOrder.BY_ROW, true, true, false);
					ventanaGrafico(graficoCircular, 1000, 400);
					break;

				case 2:
					JFreeChart graficoArea = ChartFactory.createStackedAreaChart("Pizzas Favoritas", "Pizzas",
							"Amantes de esa pizza", dataset);
					ventanaGrafico(graficoArea, 900, 400);
					break;

				case 3:
					JFreeChart graficaBarras = ChartFactory.createBarChart("Pizzas Favoritas", "PIZZAS",
							"Amantes de esta pizza", dataset);
					ventanaGrafico(graficaBarras, 1000, 500);
					break;

				case 4:
					JFreeChart graficaLineas = ChartFactory.createLineChart3D("Pizzas Favoritas", "PIZZAS",
							"Amantes de esta pizza", dataset);
					ventanaGrafico(graficaLineas, 800, 500);
					break;

				}
			}

			private DefaultCategoryDataset crearDataSet() {
				DefaultCategoryDataset dcDataset = new DefaultCategoryDataset();

				dcDataset.setValue(contMargarita, "En restaurante", "Margarita");
				dcDataset.setValue(contBarbacoa, "En restaurante", "Barbacoa");
				dcDataset.setValue(contCalzone, "En restaurante", "Calzone");
				dcDataset.setValue(contCuatroQuesos, "En restaurante", "Cuatro Quesos");
				dcDataset.setValue(contHawaiana, "En restaurante", "Hawaiana");
				dcDataset.setValue(contMarinera, "En restaurante", "Marinera");
				dcDataset.setValue(contProsciutto, "En restaurante", "Prosciutto");
				dcDataset.setValue(contVegetariana, "En restaurante", "Vegetariana");

				dcDataset.setValue(contMargaritaDom, "A domicilio", "Margarita");
				dcDataset.setValue(contBarbacoaDom, "A domicilio", "Barbacoa");
				dcDataset.setValue(contCalzoneDom, "A domicilio", "Calzone");
				dcDataset.setValue(contCuatroQuesosDom, "A domicilio", "Cuatro Quesos");
				dcDataset.setValue(contHawaianaDom, "A domicilio", "Hawaiana");
				dcDataset.setValue(contMarineraDom, "A domicilio", "Marinera");
				dcDataset.setValue(contProsciuttoDom, "A domicilio", "Prosciutto");
				dcDataset.setValue(contVegetarianaDom, "A domicilio", "Vegetariana");

				return dcDataset;
			}
		});
		btnMostrarResultado.setBounds(84, 350, 206, 37);
		getContentPane().add(btnMostrarResultado);

		lblSeleccionGrafica = new JLabel("Seleccione el tipo de grafica");
		lblSeleccionGrafica.setForeground(new Color(204, 0, 0));
		lblSeleccionGrafica.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		lblSeleccionGrafica.setBounds(73, 277, 250, 21);
		getContentPane().add(lblSeleccionGrafica);

	}

	public void ventanaGrafico(JFreeChart graficoParam, int ancho, int alto) {
		Color rosaFondo = new Color(255, 228, 225);
		Color blancoFondo = new Color(245, 245, 245);
		graficoParam.setBackgroundPaint(rosaFondo);
		graficoParam.getPlot().setBackgroundPaint(blancoFondo);
		ChartPanel grafico = new ChartPanel(graficoParam);

		JFrame Fventana = new JFrame("Gráfica");
		Fventana.setSize(ancho, alto);
		Fventana.setVisible(true);
		Fventana.getContentPane().add(grafico);

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ancho, alto);
		Fventana.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					VentanaPrincipal vp = new VentanaPrincipal();

					vp.getIinit();
					vp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
