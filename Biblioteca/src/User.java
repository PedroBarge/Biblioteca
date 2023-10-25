public class User {
    String nameUser;
    String ageUser;
    String lastBook;

    public User(String nameUser, String ageUser) {
        this.nameUser = nameUser;
        this.ageUser = ageUser;
    }

    public void UserWithBook(String nameUser, String ageUser , String lastBook){
        this.nameUser = nameUser;
        this.ageUser = ageUser;
        this.lastBook = lastBook;
    }
}
