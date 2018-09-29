
package Controllers;
import Views.View;
import models.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Controller {
    
     View view;
    Model model;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.jb_nuevo)
                    nuevo();
            else if(e.getSource() == view.jb_guardar){
                guardar();
            }
        }
    };

    

    public Controller(View view, Model model) {
        
        this.view = view;
        this.model = model;
        this.view.jb_guardar.addActionListener(ac);
        this.view.jb_nuevo.addActionListener(ac);
        initComponents();
        
    }
    
    public void nuevo(){
        view.jtf_nombre.setText("");
        view.jtf_email.setText("");
    }

 public void guardar(){
        model.setNombre(view.jtf_nombre.getText());
        model.setEmail(view.jtf_email.getText());
        model.writeFile();
    }
 
 private void initComponents(){
        view.setVisible(true);
        model.readFile();
        view.jtf_nombre.setText(model.getNombre());
        view.jtf_email.setText(model.getEmail());
        
    }
    
}
