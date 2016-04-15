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
    
    private boolean educationAdmin;
    private boolean researchAdmin;
    private boolean systemAmdmin;
    private boolean utbildning;
    private boolean forskning;
    private String namn;
    private String username;
    private int id;

    

    /**
     * @return the utbildning
     */
    public boolean isUtbildning() {
        return utbildning;
    }

    /**
     * @param utbildning the utbildning to set
     */
    public void setUtbildning(boolean utbildning) {
        this.utbildning = utbildning;
    }

    /**
     * @return the forskning
     */
    public boolean isForskning() {
        return forskning;
    }

    /**
     * @param forskning the forskning to set
     */
    public void setForskning(boolean forskning) {
        this.forskning = forskning;
    }

    /**
     * @return the namn
     */
    public String getNamn() {
        return namn;
    }

    /**
     * @param namn the namn to set
     */
    public void setNamn(String namn) {
        this.namn = namn;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the educationAdmin
     */
    public boolean isEducationAdmin() {
        return educationAdmin;
    }

    /**
     * @param educationAdmin the educationAdmin to set
     */
    public void setEducationAdmin(boolean educationAdmin) {
        this.educationAdmin = educationAdmin;
    }

    /**
     * @return the researchAdmin
     */
    public boolean isResearchAdmin() {
        return researchAdmin;
    }

    /**
     * @param researchAdmin the researchAdmin to set
     */
    public void setResearchAdmin(boolean researchAdmin) {
        this.researchAdmin = researchAdmin;
    }

    /**
     * @return the systemAmdmin
     */
    public boolean isSystemAmdmin() {
        return systemAmdmin;
    }

    /**
     * @param systemAmdmin the systemAmdmin to set
     */
    public void setSystemAmdmin(boolean systemAmdmin) {
        this.systemAmdmin = systemAmdmin;
    }
    
}
