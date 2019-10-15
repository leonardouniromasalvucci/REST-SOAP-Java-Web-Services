import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author biar
 */
public class MainClass {
    
    private static List<Movie> getAllMovies(){
        MoviesCollectionService service = new MoviesCollectionService();
        ServiceInterface port = service.getMoviesCollectionPort();
        return port.getAllMovies();
    }
        
    public static void main(String[] args) {

        try {              
            List<Movie> l = getAllMovies();
            Iterator<Movie> it= l.iterator();
     
            while(it.hasNext()){
                Movie m = it.next();
                System.out.println("MOVIE");
                System.out.println(m.getId()+","+m.getTitle()+","+m.getYear());
                
                JsonObject jsonObject = new JsonParser().parse(m.getDirector()).getAsJsonObject();
                
                int s = jsonObject.get("id").getAsInt();
                String b = jsonObject.get("name").getAsString();
                String i = jsonObject.get("birth").getAsString();
                System.out.println("DIRECTOR");
                System.out.println(s+","+b+","+i);
            }                      
        }catch (Exception e){
            e.printStackTrace();
	}
        
    }  
    
}
