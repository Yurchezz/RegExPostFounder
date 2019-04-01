package ua.lviv.iot.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostRequest {

    private String filePath;
    private int postCount;
    private String currentString;
    private Pattern pattern;
    private Matcher matcher;

    public PostRequest(String filePath) {

        this.filePath = filePath;
        pattern = Pattern.compile(
                ".+:10:[0-5][0-9]:[0-5][0-9]"
                        + ".+\"POST"
                        + ".+HTTP/1\\.1\""
                        + "\\s[4-5][0-9][4-9].+");
    }

    public void showFoundPosts() {
        try (FileReader logReader = new FileReader(filePath);
             BufferedReader logBufferedReader = new BufferedReader(logReader)) {


            while ((currentString = logBufferedReader.readLine()) != null) {


                matcher = pattern.matcher(currentString);

                while (matcher.find()) {
                    System
                            .out
                            .println(
                                    currentString
                                            .substring(
                                                    matcher.start(),
                                                    matcher.end()));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int findPostsCount() {
        try (FileReader logReader = new FileReader(filePath);
             BufferedReader logBufferedReader = new BufferedReader(logReader)) {

            while ((currentString = logBufferedReader.readLine()) != null) {


                matcher = pattern.matcher(currentString);

                while (matcher.find()) {

                    postCount++;

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return postCount;
        }

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
