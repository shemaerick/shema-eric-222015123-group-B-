package Menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import MyForms.CustomerForm;
import MyForms.FarmersForm;
import MyForms.FlowerForm;
import MyForms.OrderForm;
import MyForms.PaymentForm;


public class MenuForms extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Flowermenu;
    private JMenu Ordermenu;
    private JMenu Customermenu;
    private JMenu Farmermenu;
    private JMenu Paymentmenu;
    private JMenu Logoutmenu;
    
    public MenuForms() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem FlowerItem;
    private JMenuItem OrderItem;
    private JMenuItem CustomerItem;
    private JMenuItem FarmerItem;
    private JMenuItem PaymentItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MenuForms(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Flowermenu = new JMenu("Flower");
        Ordermenu = new JMenu(" Order");
        Customermenu= new JMenu("Customer");
        Farmermenu = new JMenu("Farmer ");
        Paymentmenu = new JMenu("Payment");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Flowermenu);
        FlowerItem = new JMenuItem("FlowerForm");
        FlowerItem.addActionListener(this);
        
        menuBar.add(Ordermenu);
        OrderItem = new JMenuItem("OrderForm");
        OrderItem.addActionListener(this);
        
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Farmermenu);
        FarmerItem = new JMenuItem("FarmerForm");
        FarmerItem.addActionListener(this);
        
        menuBar.add(Paymentmenu);
        PaymentItem = new JMenuItem("PaymentForm");
        PaymentItem.addActionListener(this);
        
       

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Flowermenu.add(FlowerItem);
        Ordermenu.add(OrderItem);
        Customermenu.add(CustomerItem);
        Farmermenu.add(FarmerItem);
        Paymentmenu.add(PaymentItem);
        
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == FlowerItem) {
            new FlowerForm();
        
        } else if (e.getSource() == OrderItem) {
            new OrderForm();
        
        } else if (e.getSource() == CustomerItem) {
            new CustomerForm();
       
        } else if (e.getSource() == FarmerItem) {
           new FarmersForm();
        
        } else if (e.getSource() == PaymentItem) {
           new PaymentForm();
           
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForms("TO BLOOM HUB CONNECTING FLOWERS AND FLORISTS"));
    }
}






