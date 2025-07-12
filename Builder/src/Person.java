import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    // Конструктор с минимальными обязательными полями (имя и фамилия)
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Конструктор с дополнительным параметром возраста
    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    // Проверяем, известен ли возраст (age != null)
    public boolean hasAge() {
        return age != null;
    }

    // Проверяем, известен ли адрес (address != null и не пустая строка)
    public boolean hasAddress() {
        return address != null && !address.isEmpty();
    }

    // Геттеры для всех полей
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // Возвращаем OptionalInt для возраста, так как он может быть неизвестен
    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Увеличиваем возраст на 1, если он известен
    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    // Создаем билдер для ребенка с уже заполненными фамилией и адресом родителя
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname) // Ребенок наследует фамилию
                .setAddress(this.address); // И адрес проживания
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(surname);
        if (hasAge()) sb.append(", возраст ").append(age);
        if (hasAddress()) sb.append(", проживает в г. ").append(address);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        if (age != null) result = 31 * result + age;
        if (address != null) result = 31 * result + address.hashCode();
        return result;
    }
}