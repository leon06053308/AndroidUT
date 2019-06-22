package com.aiways.androidut.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InjectMockTest1 {
    @Mock
    private User user;

    @Mock
    private ArticleDatabase database;

    @InjectMocks
    private ArticleManager manager;

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
