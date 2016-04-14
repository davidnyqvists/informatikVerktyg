 
package grafiskinterface;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
/**jj
 *
 * @author Simon Jonas
 */
public class GrafikHelper {
    
    private static JFrame nuvarande;
    
    
    public static void GrafikHelper() {
    
        
}
    public static void InitieraMain() {
        
        nuvarande = new Main();
        nuvarande.setVisible(true);  
    }
    
    public static void InitieraLogIn() {
        
        nuvarande = new LoginScreen();
        nuvarande.setVisible(true);
    }
    
    public static void InitieraAccountManagement() {
        
        nuvarande = new AccountManagement();
        nuvarande.setVisible(true);  
    }
    
    public static void InitieraSkapaMote() {
        
        nuvarande = new SkapaMote();
        nuvarande.setVisible(true);  
    }
    
    public static void InitieraSeMoten() {
        
        nuvarande = new SeMoten();
        nuvarande.setVisible(true);  
    }
    
    public static void DisposeFrame()
    {
        nuvarande.dispose();
    }
    
    public static void InitieraCreateNewPost() {
        new CreateNewPostFrame().setVisible(true);
    }
    
    
    
   
    
    
}
