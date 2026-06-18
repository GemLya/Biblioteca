import model.Persona;
public class App{
    public static void main(String[] args) throws Exception{

        Persona per01= new Persona("Leilani");
        per01.setPeso(50);
        per01.setEst(1.65);


        per01.defineEstastus();


       System.out.println("La persona 01 se llama:" + per01.getNombre());
       
       
       
       
       System.out.println(per01);

    }
}
