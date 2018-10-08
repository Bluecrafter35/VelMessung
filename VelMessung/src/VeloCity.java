
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph Mautner
 */
public class VeloCity
{
    private LocalDate datum;
    private LocalTime uhrzeit;
    private String kennzeichen;
    private int gemessen;
    private int erlaubt;
    private int übertreten;
    
    public VeloCity(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int gemessen, int erlaubt)
    {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
        this.übertreten = gemessen-erlaubt <0 ? 0:gemessen-erlaubt;
    }

    public VeloCity()
    {
        this.datum=null;
        this.uhrzeit=null;
        this.kennzeichen=null;
        this.gemessen=0;
        this.erlaubt=0;
        this.übertreten=0;
    }
    

    public LocalDate getDatum()
    {
        return datum;
    }

    public LocalTime getUhrzeit()
    {
        return uhrzeit;
    }

    public String getKennzeichen()
    {
        return kennzeichen;
    }

    public int getGemessen()
    {
        return gemessen;
    }

    public int getErlaubt()
    {
        return erlaubt;
    }

    public int getÜbertreten()
    {
        return übertreten;
    }
    
    
    
    
    
}
