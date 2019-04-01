package ua.lviv.iot.models;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class PostRequestTest {

    private PostRequest request;

    @Before
    public void setUp() throws Exception {

        request = new PostRequest("logs.txt");

    }

    @Test
    public void findPostsCount() {

        File testFile = new File(request.getFilePath());

        assertTrue("file " + request.getFilePath() + " doesn't exist ", testFile.exists());
        assertEquals("something wrong with findPostsCount", 3, request.findPostsCount());

    }

    @Test
    public void showFoundPosts() {

        request.showFoundPosts();

    }
}