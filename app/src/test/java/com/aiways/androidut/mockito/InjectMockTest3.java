package com.aiways.androidut.mockito;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class InjectMockTest3 {
    @Mock
    private User user;

    @Mock
    private ArticleDatabase database;

    @InjectMocks
    private ArticleManager manager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInjectMock(){

        manager.initialize();

        Mockito.verify(database).addListener(Mockito.any(ArticleListener.class));
    }

    public static class ArticleManager {
        private User user;
        private ArticleDatabase database;

        public ArticleManager(User user, ArticleDatabase database) {
            super();
            this.user = user;
            this.database = database;
        }

        public void initialize() {
            database.addListener(new ArticleListener());
        }
    }

    public static class User {
    }

    public static class ArticleListener {
    }

    public static class ArticleDatabase {
        public void addListener(ArticleListener listener) {
        }
    }
}
