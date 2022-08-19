

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// 
// Decompiled by Procyon v0.5.36
// 

class PinButton extends JButton implements ActionListener
{
    Binarypin app;
    
    PinButton(final Binarypin app, final String text, final int x, final int y, final int width, final int height) {
        super(text);
        this.app = app;
        this.addActionListener(this);
        this.setBounds(x, y, width, height);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        Secret.getInstance().process(this.getText().charAt(0));
        this.app.updateOutput();
    }
}

