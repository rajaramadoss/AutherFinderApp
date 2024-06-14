package autherservice.stackroute.model;

import java.util.List;

public class Docs {
    String key;
    String type;
    String name;
    String top_work;
    int work_count;

    List<String> top_subject;

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

    public int getWork_count() {
        return work_count;
    }

    public void setWork_count(int work_count) {
        this.work_count = work_count;
    }

    public List<String> getTop_subject() {
        return top_subject;
    }

    public void setTop_subject(List<String> top_subject) {
        this.top_subject = top_subject;
    }
}
