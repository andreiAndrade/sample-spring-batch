package com.sample.batch.springbatch.processor;

import com.sample.batch.springbatch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.Assert;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        Assert.notNull(person, "Person can't be null");
        Assert.notNull(person.getFirstName(), "First name can't be null");
        Assert.notNull(person.getLastName(), "Last name can't be null");

        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info(String.format("Converting (%s) into (%s)", person, transformedPerson));

        return transformedPerson;
    }
}
