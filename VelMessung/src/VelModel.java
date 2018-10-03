
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class VelModel extends AbstractTableModel
{
    private final static String[] COLUMNNAMES = {"Datum","Uhrzeit","Kennzeichen","Gemessen","Erlaubt","Übertretung"};
    
    private ArrayList<VeloCity> messwerte = new ArrayList<>();
    
    public void add(VeloCity vc)
    {
        messwerte.add(vc);
        fireTableRowsInserted(messwerte.size()-1, messwerte.size()-1);
    }
    
    @Override
    public String getColumnName(int column)
    {
        return COLUMNNAMES[column];
    }
    
    @Override
    public int getRowCount()
    {
        return messwerte.size();
    }

    @Override
    public int getColumnCount()
    {
        return COLUMNNAMES.length;
    }

    @Override
    public Object getValueAt(int rowindex, int columnindex)
    {
        VeloCity vc = messwerte.get(rowindex);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter uhr = DateTimeFormatter.ofPattern("HH:mm");
        switch(columnindex)
        {
            case 0: return vc.getDatum().format(dtf);
            case 1: return vc.getUhrzeit().format(uhr);
            case 2: return vc.getKennzeichen();
            case 3: return vc.getGemessen()+"km/h";
            case 4: return vc.getErlaubt()+"km/h";
            case 5: return vc.getÜbertreten();
            default: return "???";
        }
    }
    
}
