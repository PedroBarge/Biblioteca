class User {
    private String name;
    private int age;
    private Book[] bookWithUser = new Book[5];

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Book[] getBookWithUser() {
        return bookWithUser;
    }
}

