public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname;
        return this;
    }

    // Устанавливаем возраст с проверкой на корректность
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Создаем объект Person с проверкой обязательных полей
    public Person build() {
        // Проверяем, что обязательные поля заполнены
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия обязательны");
        }

        // Если возраст установлен, используем конструктор с возрастом
        if (age != null) {
            return new Person(name, surname, age);
        } else {
            return new Person(name, surname);
        }
    }
}
