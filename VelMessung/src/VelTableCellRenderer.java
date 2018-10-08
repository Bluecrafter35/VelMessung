
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
            label.setHorizontalAlignment((int) jtable.CENTER_ALIGNMENT);
            label.setBackground(Color.white);
            label.setForeground(Color.black);
            label.setText(o.toString());
        }
        else if(o instanceof Integer)
        {
            label.setOpaque(true);
            label.setText(o+"");
            label.setHorizontalAlignment((int) jtable.CENTER_ALIGNMENT);
            
            int i = (Integer)o;
            if(i <= 10)
            {
                label.setBackground(Color.BLUE);
                label.setForeground(Color.WHITE);
            }
            else if(i<=20)
            {
                label.setBackground(Color.YELLOW);
                label.setForeground(Color.BLACK);
            }
            else if(i<=30)
            {
                label.setBackground(Color.ORANGE);
                label.setForeground(Color.BLACK);
            }
            else
            {
                label.setBackground(Color.RED);
                label.setForeground(Color.BLACK);
            }
        }
        else if(o == null)
        {
            label.setOpaque(true);
            label.setHorizontalAlignment((int)jtable.CENTER_ALIGNMENT);
            label.setBackground(Color.WHITE);
            label.setText("");
        }
        
        if(isSelected&&o instanceof Integer==false)
        {
            label.setBackground(new Color(130,200,240,123));
        }
        
        
        c=label;
        
        return c;
    }
    
}
