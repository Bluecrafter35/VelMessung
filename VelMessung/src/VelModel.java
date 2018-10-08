
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    private VeloCity leer = new VeloCity();
    
    private Map<String, ArrayList<Integer> > map = new HashMap<>();
    
    public void add(VeloCity vc)
    {
        if(messwerte.size()>=1&&messwerte.get(0).getDatum()==null)
        {
            messwerte.remove(messwerte.get(0));
        }
        messwerte.add(vc);
        fillMap();
        fireTableRowsInserted(messwerte.size()-1, messwerte.size()-1);
    }
    
    public void delete(int i)
    {
        if(messwerte.size()>=1&&messwerte.get(0).getDatum()==null)
        {
            return;
        }
        messwerte.remove(i);
        fillMap();
        fireTableRowsDeleted(i, i);
        if(messwerte.size()==0)
        {
            messwerte.add(leer);
        }
    }
    
    public void fillMap()
    {
        map.clear();
        for(VeloCity vc : messwerte)
        {
            if(!map.containsKey(vc.getKennzeichen()))
            {
                map.put(vc.getKennzeichen(), new ArrayList<>());
            }
            map.get(vc.getKennzeichen()).add(vc.getÜbertreten());
        }
    }
    
    public Map<String,Double> calculateAvg()
    {
        Map<String,Double> results = new HashMap<>();
        Set<String> keys = map.keySet();
        double sum =0;
        for(String key: keys)
        {
            ArrayList<Integer> ints = map.get(key);
            for(int zahl: ints)
            {
                sum+=zahl;
            }
            sum/=ints.size();
            try{
                results.put(key, sum);
                
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return results;
    }
    
    public void save(File f) throws IOException, Exception
    {
        if(messwerte.size()==0||messwerte.get(0).getDatum()==null)
        {
            throw new Exception("Bitte zuerst etwas in den Table schreiben!");
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for(VeloCity vc: messwerte)
        {
            oos.writeObject(vc);
        }
        oos.flush();
    }
    public void load(File f) throws Exception
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object vc = null;
        while((vc=ois.readObject())!=null)
        {
            
            try{
                add((VeloCity)vc);
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
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
        if(vc.getDatum()==null)return null;
        if(vc.getUhrzeit()==null)return null;
        if(vc.getKennzeichen()==null)return null;
        if(vc.getGemessen()==0)return null;
        if(vc.getErlaubt()==0)return null;
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
