package accountMangement;

/**
 * Created by Christian on 2/20/2016.
 *
 * @discription this class will hold every method involving loggin to the nordicmafia.
 */
import com.jaunt.*;
import gui.Main;

public class Login {

    private String username,password;

    /**
     * An object to hold username and password
     * @param username the username of the selected user to log into
     * @param password the password || ---- || ---- ||
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;

    }

    /**
     * The method that is beeing called if the user wants to log in.
     * @return true if the user has entered the password correctly.
     */
    public boolean login() {

        // try to log in.
        boolean loginAttempt = doLogin();

        // check if the login failed
        if (!loginAttempt) {
            System.out.println("Login failed");
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Do the login request
     * @return if the request was succeeded
     */
    private boolean doLogin() {
        // get the useragent
        UserAgent userAgent = Main.getUserAgent();
        String post = "username="+username+"&password="+password+"&login=Logg+inn";

        // try to send the request to the server
        try{
            // send the request
            userAgent.sendPOST("http://www.nordicmafia.org/login.php", post);

            // update the current useragent.
            Main.setUserAgent(userAgent);
        }catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }

        // check if he managed to login to the account, by checking the content of the page.
        if (userAgent.getSource().contains("Brukernavnet eller passordet er feil."))
            return false;

        System.out.println("User is signed into the main server");

        // login to housekeeping
        if(doLoginHousekeeping(password))
            return true;
        else
            return false;
    }
    private boolean doLoginHousekeeping(String password) {
        UserAgent userAgent = Main.getUserAgent();
        String post = "loginpwd="+password+"&dologin=Logg+inn";
        // try to send the request to the server
        try{
            // send the request
            userAgent.sendPOST("http://www.nordicmafia.org/housekeeping/index.php", post);

            // update the current useragent.
            Main.setUserAgent(userAgent);
        }catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
            System.err.println(e);
        }
        if (userAgent.getSource().contains("Feil"))
            return false;
        return false;
    }
}
