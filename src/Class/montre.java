package Class;


public final class montre { // we will instanciate objects from this class, so we use final
    private int heure; // we use private to use the attribute in specific scenarios (not usable in all classes and methods) to limit unnecessary usage
    private int minute; // we don't use protected in this case since protected allows modifying those attributes in other child classes with the same attribute name (we don't want that in that case)
    public void Setheure(int heure){ //unchecked exception (ie. we don't need throws after the method's name)
        if (heure<0 || heure>23)
            throw new RuntimeException("Heure invalide");
        this.heure=heure;
    }
    public void Setminute(int min){ // Setters are always void
        if (min<0 || min>59)
            throw new RuntimeException("Heure (minutes) invalide");
        this.minute=min;
    }
    public int Getheure(){
        return heure;
    }
    public int Getminute(){
        return minute;
    }
    public montre(int heure, int min){
        this.Setheure(heure); // same thing as: this.heure=heure; -- this is unnecessary in this case
        this.Setminute(min);
    }
    public montre(montre m){
        Setheure(m.Getheure());
        Setminute(m.Getminute());
    }

    //this.heure VS this.Getheure()
    //

    public String toString(){
        String sheure = String.format(String.valueOf(this.Getheure()));
        String sminutes = String.format(String.valueOf(this.Getminute()));
        if (this.minute>0 && this.minute<10) { // if the object is rolex for example, this.minute will be rolex.minute
            sminutes = "0" + sminutes;
        }
        if (this.heure>0 && this.heure<10){
            sheure = "0" + sheure;
        }
        return sheure+":"+sminutes;
    }


}
