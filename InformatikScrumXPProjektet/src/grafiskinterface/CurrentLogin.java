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
public class CurrentLogin {
    
    private static boolean educationAdmin;
    private static boolean researchAdmin;
    private static boolean systemAmdmin;
    private static boolean utbildning;
    private static boolean forskning;
    private static String namn;
    private static String username;
    private static int id;

    /**
     * @return the educationAdmin
     */
    public static boolean isEducationAdmin() {
        return educationAdmin;
    }

    /**
     * @param aEducationAdmin the educationAdmin to set
     */
    public static void setEducationAdmin(boolean aEducationAdmin) {
        educationAdmin = aEducationAdmin;
    }

    /**
     * @return the researchAdmin
     */
    public static boolean isResearchAdmin() {
        return researchAdmin;
    }

    /**
     * @param aResearchAdmin the researchAdmin to set
     */
    public static void setResearchAdmin(boolean aResearchAdmin) {
        researchAdmin = aResearchAdmin;
    }

    /**
     * @return the systemAmdmin
     */
    public static boolean isSystemAmdmin() {
        return systemAmdmin;
    }

    /**
     * @param aSystemAmdmin the systemAmdmin to set
     */
    public static void setSystemAmdmin(boolean aSystemAmdmin) {
        systemAmdmin = aSystemAmdmin;
    }

    /**
     * @return the utbildning
     */
    public static boolean isUtbildning() {
        return utbildning;
    }

    /**
     * @param aUtbildning the utbildning to set
     */
    public static void setUtbildning(boolean aUtbildning) {
        utbildning = aUtbildning;
    }

    /**
     * @return the forskning
     */
    public static boolean isForskning() {
        return forskning;
    }

    /**
     * @param aForskning the forskning to set
     */
    public static void setForskning(boolean aForskning) {
        forskning = aForskning;
    }

    /**
     * @return the namn
     */
    public static String getNamn() {
        return namn;
    }

    /**
     * @param aNamn the namn to set
     */
    public static void setNamn(String aNamn) {
        namn = aNamn;
    }

    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }

    

   
}
