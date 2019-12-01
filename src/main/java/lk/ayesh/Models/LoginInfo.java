package lk.ayesh.Models;

public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (InputValidator.stringWithNumbersAndLetters(username)) {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (InputValidator.stringWithNumbersAndLetters(password)) {
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
