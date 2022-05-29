package sg.edu.np.mad.wk6practical;

public class User {
    String name;
    String description;
    Integer id;
    Boolean followed;

    public User(){};

    public User(String n, String d, int i, boolean f)
    {
        this.name = n;
        this.description = d;
        this.followed = f;
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }
}
