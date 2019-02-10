package ru.job4j.search;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Nikita", "Siniagin", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("534");
        assertThat(persons.iterator().next().getSurname(), is("Siniagin"));
    }
}
