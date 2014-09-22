package com.payu.workshops;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.repositories.BookRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookRepositoryCustomTest extends AbstractJpaTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void shouldReverseWordsInBookTitle() {
        // when
        repository.reverseWordsInBookTile(10601L);

        // then
        assertThat(repository.findOne(10601L).getTitle(), equalTo("Dummies for Peachtree"));
    }
}
