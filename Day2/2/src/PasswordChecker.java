public class PasswordChecker {
    private String[] _passwordsArray;

    public PasswordChecker (String[] passwordsArray){
        this._passwordsArray = passwordsArray;
    }

    public int checkPasswords(){
        boolean correct      = false;
        int correctPasswords = 0;
        for (String s : _passwordsArray){
            correct = checkPassword( s );
            if (correct){
                correctPasswords++;
            }
        }
        return correctPasswords;
    }

    private boolean checkPassword(String password){
        String[] passwordSplitted = password.split( "-" );
        int validPosition = Integer.valueOf( passwordSplitted[0] );
        passwordSplitted = passwordSplitted[1].split( " ", 2 );
        int invalidPosition = Integer.valueOf( passwordSplitted[0] );
        passwordSplitted = passwordSplitted[1].split( ":" );
        char checkingChar = passwordSplitted[0].charAt( 0 );
        password = passwordSplitted[1].substring( 1, passwordSplitted[1].length() );
        return check( validPosition, invalidPosition, checkingChar, password );
    }

    private boolean check (int pos1, int pos2, char ch, String password){
        if (password.charAt( pos1-1 ) == ch && password.charAt( pos2-1 ) != ch){
            return true;
        }
        if (password.charAt( pos1-1 ) != ch && password.charAt( pos2-1 ) == ch){
            return true;
        }

        return false;
    }
}
