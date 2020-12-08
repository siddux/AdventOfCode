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
        int minChar = Integer.valueOf( passwordSplitted[0] );
        passwordSplitted = passwordSplitted[1].split( " ", 2 );
        int maxChar = Integer.valueOf( passwordSplitted[0] );
        passwordSplitted = passwordSplitted[1].split( ":" );
        char checkingChar = passwordSplitted[0].charAt( 0 );
        password = passwordSplitted[1].substring( 1, passwordSplitted[1].length() );
        return check( minChar, maxChar, checkingChar, password );
    }

    private boolean check (int min, int max, char ch, String password){
        int charNumber = 0;
        for (char c : password.toCharArray()){
            if (c == ch){
                charNumber++;
            }
            if (charNumber > max){
                return false;
            }
        }
        if (charNumber >= min && charNumber <= max){
            return true;
        }
        return false;
    }
}
