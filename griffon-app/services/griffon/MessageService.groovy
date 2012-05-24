package griffon

import javax.swing.JOptionPane

class MessageService {
    def show(String message){
        JOptionPane.showMessageDialog(app.windowManager.Windows[0],message)
    }
}