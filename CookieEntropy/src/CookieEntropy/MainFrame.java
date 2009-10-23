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

import java.util.*;

/**
 *
 * @author Ming
 */
public class MainFrame extends javax.swing.JFrame 
        implements CookieCollectorEvent {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLogoutURL = new javax.swing.JTextField();
        chkUseLogout = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoginParam = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRun = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLoginURL = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cboxMethod = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRepeats = new javax.swing.JTextField();
        pnlTable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        btnRun.setText("Collect!");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        jLabel1.setText("URL:");

        txtLoginURL.setText("http://www.google.com");

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSave.setText("Save");

        cboxMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Get", "Post" }));
        cboxMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMethodActionPerformed(evt);
            }
        });

        jLabel3.setText("Method:");

        jLabel4.setText("Repeat:");

        txtRepeats.setText("10");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboxMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtRepeats, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnRun)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(txtLoginURL, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(433, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLoginURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtRepeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRun)
                    .addComponent(btnLoad)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.NORTH);

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean cookieTableNeedRecreate = false;
    int	    cookieTableRows = 0;
    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        System.out.println("hello world");
        String loginURL = txtLoginURL.getText();
	int repeats = Integer.parseInt(txtRepeats.getText());
        CookieCollector cc = new CookieCollector(loginURL, repeats, this);
	cc.useHttpGetMethod();

	cookieTableNeedRecreate = true;
	cookieTableRows = repeats;

	btnRun.setEnabled(false);
	new Thread(cc).start();
}//GEN-LAST:event_btnRunActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadActionPerformed

    private void cboxMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMethodActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
	// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    javax.swing.JTable tblCookie = null;
    Map<String, Integer> tblColumns = new HashMap<String, Integer>(); // holds column names and its index (from 0)
    int nextRow = 0;

    public void recreateCookieTable(int rows, int cols) {
	tblCookie = new javax.swing.JTable(rows, cols);
	javax.swing.JScrollPane sp = new javax.swing.JScrollPane(tblCookie);
	tblCookie.setFillsViewportHeight(true);
	pnlTable.removeAll();

	javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
	pnlTable.setLayout(pnlTableLayout);
	pnlTableLayout.setHorizontalGroup(
		pnlTableLayout.createParallelGroup(
		    javax.swing.GroupLayout.Alignment.LEADING).addComponent(
			sp, javax.swing.GroupLayout.DEFAULT_SIZE, 907, 
			Short.MAX_VALUE));
	pnlTableLayout.setVerticalGroup(
		pnlTableLayout.createParallelGroup(
		    javax.swing.GroupLayout.Alignment.LEADING).addComponent(
			sp, javax.swing.GroupLayout.DEFAULT_SIZE, 384, 
			Short.MAX_VALUE));
    }

    public void receiveCookie (List<KeyValuePair> params,
            List<KeyValuePair> cookies) {
        System.out.println("Receive " + cookies.size() + " Cookie\n");

	List<KeyValuePair> c = CookieCollector.decomposeCookies(cookies);

	if (cookieTableNeedRecreate) {
	    recreateCookieTable(cookieTableRows, c.size());
	    tblColumns.clear();
	    for (int i=0; i<c.size(); i++) {
		String name = c.get(i).key;
		tblColumns.put(name, i);
		tblCookie.getColumnModel().getColumn(i).setHeaderValue(name);
	    }
	    nextRow = 0;
	    cookieTableNeedRecreate = false;
	}
	Iterator<KeyValuePair> it = c.iterator();
	while (it.hasNext()) {
	    KeyValuePair kv = it.next();
	    Integer cidx = tblColumns.get(kv.key);
	    if (cidx != null)
		tblCookie.setValueAt(kv.value, nextRow, cidx);
	    System.out.println("key="+kv.key+"\tvalue="+kv.value);
	}
	nextRow ++;
    }

    public void receiveException (Exception e) {
        System.out.println("Receive Exception\n" + e);
    }

    public void receiveThreadEnds () {
	btnRun.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboxMethod;
    private javax.swing.JCheckBox chkUseLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JTable tblLoginParam;
    private javax.swing.JTextField txtLoginURL;
    private javax.swing.JTextField txtLogoutURL;
    private javax.swing.JTextField txtRepeats;
    // End of variables declaration//GEN-END:variables

}
