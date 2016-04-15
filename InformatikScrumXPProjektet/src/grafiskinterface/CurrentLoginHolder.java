/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskinterface;


/**
 *
 * @author Simon
 */
public class CurrentLoginHolder {
    
    private static CurrentLogin nuvarandeLogIn;
    private static String user;
    private static String pass;

    /**
     * @return the nuvarandeLogIn
     */
    public static CurrentLogin getNuvarandeLogIn() {
        return nuvarandeLogIn;
    }

    public static void InitieraHoldern(CurrentLogin currentUser, String username, String password) {
        nuvarandeLogIn = currentUser;
        user = username;
        pass = password;
        currentUser.setEducationAdmin(true);
        currentUser.setResearchAdmin(true);
        currentUser.setSystemAmdmin(true);
        currentUser.setUtbildning(true);
        currentUser.setForskning(true);
    }
    
    
}

