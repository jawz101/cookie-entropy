/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Oct 19, 2009, 11:08:09 AM
 */

package CookieEntropy;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;

/**
 * 
 * @author Ming
 */
public class MainFrame extends javax.swing.JFrame implements
		CookieCollectorEvent {

	/** Creates new form MainFrame */
	public MainFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLogoutURL = new javax.swing.JTextField();
        chkUseLogout = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoginParam = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cbbCookies = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnShowEntropy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLoginURL = new javax.swing.JTextField();
        btnRun = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRepeats = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        chkUseLogout.setText("Logout URL:");

        tblLoginParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLoginParam);

        jLabel2.setText("Login Params: Put param names in the first row and values follow rows");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chkUseLogout)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtLogoutURL, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkUseLogout)
                        .addComponent(txtLogoutURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(378, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(151, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cookie Entropy Analysis"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(pnlTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1060, 270));

        jLabel5.setText("Cookie:");

        btnShowEntropy.setText("Entropy");
        btnShowEntropy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEntropyActionPerformed(evt);
            }
        });

        jLabel3.setText("123");

        jLabel7.setText("abc");

        jLabel6.setText("abcd");

        jLabel1.setText("URL:");

        txtLoginURL.setText("http://www.google.com");

        btnRun.setText("Collect");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        jLabel4.setText("Repeat:");

        txtRepeats.setText("10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLoginURL, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepeats, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3572, 3572, 3572))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLoginURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRun)
                    .addComponent(jLabel4)
                    .addComponent(txtRepeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Collect Cookies", jPanel2);

        jButton1.setText("Select File");

        jLabel8.setText("Choose Paros Data File:");

        jButton2.setText("Get Cookies");

        jTextField1.setText("google.com");

        jLabel9.setText("Choose Host:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1)
                    .addComponent(jLabel9)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Paros Cookies", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCookies, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowEntropy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbCookies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(btnShowEntropy))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("TabbedPane");

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            // TODO add your handling code here:
        }//GEN-LAST:event_jTable1MouseClicked

	boolean cookieTableNeedRecreate = false;
	int cookieTableRows = 0;

	private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRunActionPerformed
		System.out.println("hello world");
		String loginURL = txtLoginURL.getText();
		int repeats = Integer.parseInt(txtRepeats.getText());
		CookieCollector cc = new CookieCollector(loginURL, repeats, this);
		cc.useHttpGetMethod();

		cookieTableNeedRecreate = true;
		cookieTableRows = repeats;

		btnRun.setEnabled(false);
		new Thread(cc).start();
		jLabel6.setText("Session Management: Unknown or not used");
	}// GEN-LAST:event_btnRunActionPerformed
	
	private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRunActionPerformed
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.addChoosableFileFilter(new ParosDataFileFilter());
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				file = jfc.getSelectedFile();
		}
	}// GEN-LAST:event_btnRunActionPerformed
	
	private void btnGetCookiesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRunActionPerformed
		String host = jTextField1.getText();
		try {
		ReadParosData rpd = new ReadParosData(file, host);
		
		String[] cookies = rpd.getCookies();
		
		for (int i = 0; i < cookies.length; i++){
			CookieParser cp = new CookieParser(cookies[i]);
			List<KeyValuePair> cookieList = cp.parseCookie();
			Iterator<KeyValuePair> cookieIterator = cookieList.iterator();
			while (cookieIterator.hasNext()) {
				System.out.println(cookieIterator.next().toString());
			}
		}
		}catch (IOException ioe){
			System.out.println("Error reading file!");
		}
	}
	
	//private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
		// TODO add your handling code here:
	//}// GEN-LAST:event_jTable1MouseClicked

	private void btnShowEntropyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnShowEntropyActionPerformed
		int cindex = cbbCookies.getSelectedIndex();
		CookieValues cv = allCookieValues[cindex];
		CookieAnalyzer ca = new CookieAnalyzer(cv);
		System.out.println(ca.encoding());
		System.out.println(ca.countChars());
		System.out.println(ca.totalEntropy());
		String[] entropy = ca.columnEntropy();
		for (int i = 0; i < entropy.length; i++)
			System.out.println(entropy[i]);
		entropy = ca.cookieEntropy();
		for (int i = 0; i < entropy.length; i++)
			System.out.println(entropy[i]);
		//System.out.print(cv);
	}// GEN-LAST:event_btnShowEntropyActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	javax.swing.JTable tblCookie = null;
	// holds column names and its index (from 0)
	Map<String, Integer> tblColumns = new HashMap<String, Integer>(); 
	
	int nextRow = 0;
	CookieValues[] allCookieValues = null;

	public void recreateCookieTable(int rows, int cols) {
		tblCookie = new javax.swing.JTable(rows, cols);
		javax.swing.JScrollPane sp = new javax.swing.JScrollPane(tblCookie);
		tblCookie.setFillsViewportHeight(true);
		pnlTable.removeAll();

		javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(
				pnlTable);
		pnlTable.setLayout(pnlTableLayout);
		pnlTableLayout.setHorizontalGroup(pnlTableLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(sp,
				javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE));
		pnlTableLayout.setVerticalGroup(pnlTableLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(sp,
				javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE));
	}

	public void receiveCookie(List<KeyValuePair> params,
			List<KeyValuePair> cookies) {
		System.out.println("Receive " + cookies.size() + " Cookie\n");

		List<KeyValuePair> c = CookieCollector.decomposeCookies(cookies);

		if (cookieTableNeedRecreate) {
			recreateCookieTable(cookieTableRows, c.size());
			tblColumns.clear();
			cbbCookies.removeAllItems();
			allCookieValues = new CookieValues[c.size()];
			for (int i = 0; i < c.size(); i++) {
				String name = c.get(i).key;
				tblColumns.put(name, i);
				cbbCookies.addItem(name);
				tblCookie.getColumnModel().getColumn(i).setHeaderValue(name);

				allCookieValues[i] = new CookieValues(name);
				CookieAnalyzer ca = new CookieAnalyzer(allCookieValues[i]);
				if (!ca.sessionManagement().equals("Unknown"))
					jLabel6.setText("Session Management: "
								+ ca.sessionManagement());
				if (ca.googleAnalytics())
					jLabel7.setText("Google Analytics used");
			}

			nextRow = 0;
			cookieTableNeedRecreate = false;
		}

		Iterator<KeyValuePair> it = c.iterator();
		while (it.hasNext()) {
			KeyValuePair kv = it.next();
			Integer cidx = tblColumns.get(kv.key);
			if (cidx != null) {
				tblCookie.setValueAt(kv.value, nextRow, cidx);
				allCookieValues[cidx].addValue(kv.value);
			}
			System.out.println("key=" + kv.key + "\tvalue=" + kv.value);
		}
		nextRow++;
		if (characteristics) {
			// we only need the first cookie
			CookieAnalyzer ca = new CookieAnalyzer(allCookieValues[0]);
			jLabel3.setText("Number of Cookie Parameters: " + c.size());
		}
	}

	public void receiveException(Exception e) {
		System.out.println("Receive Exception\n" + e);
	}

	public void receiveThreadEnds() {
		btnRun.setEnabled(true);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnShowEntropy;
    private javax.swing.JComboBox cbbCookies;
    private javax.swing.JCheckBox chkUseLogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JTable tblLoginParam;
    private javax.swing.JTextField txtLoginURL;
    private javax.swing.JTextField txtLogoutURL;
    private javax.swing.JTextField txtRepeats;
    // End of variables declaration//GEN-END:variables
	private boolean characteristics = true;
	private File file;
}

class ParosDataFileFilter extends javax.swing.filechooser.FileFilter {

    @Override public boolean accept(File f) {
            String s = f.getName();
            if (f.isDirectory())
            	return true;
            if (s.length() > 13) {
                    s = s.substring(s.length() - 13, s.length());

                    if (s.equalsIgnoreCase(".session.data"))
                            return true;
            }

            return false;
    }

    @Override public String getDescription() {
            return "Paros Data Files (*.session.data)";
    }
}
