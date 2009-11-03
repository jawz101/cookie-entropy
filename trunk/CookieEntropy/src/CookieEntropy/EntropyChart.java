package CookieEntropy;

/*
 OpenChart2 Java Charting Library and Toolkit
 Copyright (C) 2005-2007 Approximatrix, LLC
 Copyright (C) 2001  Sebastian M�ller
 http://www.approximatrix.com

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 RandomChart.java

 */

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import com.approximatrix.charting.model.*;
import com.approximatrix.charting.swing.*;
import com.approximatrix.charting.render.*;
import com.approximatrix.charting.coordsystem.*;
import com.approximatrix.charting.CoordSystem;

/**
 * Creates a dialog that contains a scatter plot of random data points. This
 * example also places a menu bar in the dialog and a button bar below the plot
 * to allow the addition and removal of series from the chart. The tutorial
 * demonstrates the ease at which plots can be modified in real-time, including
 * data sets, the title, and the legend.
 * 
 * @author armstrong
 * 
 */
public class EntropyChart{

	/** A menu item for closing the dialog */
	//JMenuItem m_exit = null;

	/** The panel containing our chart */
	ChartPanel chartPanel = null;
	public EntropyChart(JDialog dlg, String cookieName, String totalEntropy,
		String cookieLen, String cookieEncoding, String level, String[] x, double[] y) {
	    JPanel chartPane = new JPanel();
	    chartPane.setLayout(new BorderLayout());
	    dlg.setContentPane(chartPane);

	    double[][] data = new double[1][];
	    data[0] = y;
	    String[] row = new String[1];
	    row[0] = " ";
	    ObjectChartDataModel model = new ObjectChartDataModel(data, x, row);
	    model.setMaximumValueY(8);
	    model.setMinimumValueY(0);
	    model.setAutoScale(false);
	    //model.isAutoScale()

	    CoordSystem coord = new CoordSystem(model, "Column", "Entropy");

	    chartPanel = new ChartPanel(model, " Entropy: " + totalEntropy
			+" Encoding: "+cookieEncoding+" Len: "+cookieLen + " Entropy Level: " + level);
	    chartPanel.getTitle().setFont(new java.awt.Font("Courier",
			 java.awt.Font.PLAIN, 14));
		// Add the coordinate system to the chart
	    chartPanel.setCoordSystem(coord);

	    LineChartRenderer renderer = new LineChartRenderer(coord, model);
	    //renderer.setAllowBuffer(false);
	    chartPanel.addChartRenderer(renderer, 0);
	    chartPane.add(chartPanel, BorderLayout.CENTER);
	    chartPanel.getLegend().setColorBox(new java.awt.Rectangle());
	    chartPanel.repaint();
	}

}