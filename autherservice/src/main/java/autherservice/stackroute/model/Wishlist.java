package autherservice.stackroute.model;

public class Wishlist {
    //@Id
    private String username;
    private String key;
    private String type;
    private String name;
    private String top_work;
    private Integer work_count;
    private String top_subject;

    public Wishlist(String username, String key, String type, String name, String top_work, Integer work_count, String top_subject) {
        this.username = username;
        this.key = key;
        this.type = type;
        this.name = name;
        this.top_work = top_work;
        this.work_count = work_count;
        this.top_subject = top_subject;
    }
    public Wishlist(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTop_work() {
        return top_work;
    }

    public void setTop_work(String top_work) {
        this.top_work = top_work;
    }

    public Integer getWork_count() {
        return work_count;
    }

    public void setWork_count(Integer work_count) {
        this.work_count = work_count;
    }

    public String getTop_subject() {
        return top_subject;
    }

    public void setTop_subject(String top_subject) {
        this.top_subject = top_subject;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "username='" + username +
                ", key='" + key +
                ", type='" + type +
                ", name='" + name +
                ", top_work='" + top_work +
                ", work_count=" + work_count +
                ", top_subject='" + top_subject +
                '}';
    }
}