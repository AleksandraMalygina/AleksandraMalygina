package hw5.data;

import java.util.Arrays;
import java.util.List;

public class Ex1TestData {

    private String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private String pageTitle = "Home Page";
    private String login = "Roman";
    private String password = "Jdi1234";
    private String userName = "ROMAN IOVLEV";
    private List<String> logLines = Arrays.asList(
            "water: condition changed to true",
            "wind: condition changed to true",
            "metal: value changed to selen",
            "colors: value changed to yellow");

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getLogLines() {
        return logLines;
    }

    public void setLogLines(List<String> logLines) {
        this.logLines = logLines;
    }
}
