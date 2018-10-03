
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class VelTableCellRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel label = new JLabel();
        Component c = null;
        if(o instanceof String)
        {
            label.setOpaque(true);
            label.setBackground(Color.white);
            label.setForeground(Color.black);
            label.setText(o.toString());
        }
        
        if(isSelected)
        {
            label.setBackground(Color.LIGHT_GRAY);
        }
        
        
        c=label;
        
        return c;
    }
    
}
